package system.service.impl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.LoginUser;
import system.model.Token;
import system.service.TokenService;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 16:50
 **/
@Service
@Transactional
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Value("${token.jwtSecret}")
    private String jwtSecret;

    private static Key KEY = null;
    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    @Autowired
    private RedisTemplate<String, LoginUser> redisTemplate;

    @Override
    public Token saveToken(LoginUser user) {
        user.setToken(UUID.randomUUID().toString());
        cacheLoginUser(user);
        String token = createJWTToken(user);
        return new Token(token,user.getLoginTime());
    }

    private String createJWTToken(LoginUser loginUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(LOGIN_USER_KEY, loginUser.getToken());// 放入一个随机字符串，通过该串可找到登陆用户
        String jwtToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();
        return jwtToken;
    }
    private Key getKeyInstance() {
        if (KEY == null) {
            synchronized (TokenServiceImpl.class) {
                if (KEY == null) {// 双重锁
                    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
                    KEY = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
                }
            }
        }
        return KEY;
    }

    private void cacheLoginUser(LoginUser user) {
        user.setLoginTime(System.currentTimeMillis());
        user.setExpireTime(user.getLoginTime()+ expireSeconds * 1000);
        // 根据uuid将loginUser缓存
        redisTemplate.boundValueOps(getTokenKey(user.getToken())).set(user, expireSeconds, TimeUnit.SECONDS);
    }
    private String getTokenKey(String uuid) {
        return "tokens:" + uuid;
    }

    @Override
    public void refresh(LoginUser user) {
        cacheLoginUser(user);
    }

    @Override
    public LoginUser getLoginUser(String token) {
        String uuid = getUUIDFromJWT(token);
        if (uuid != null) {
            return redisTemplate.boundValueOps(getTokenKey(uuid)).get();
        }
        return null;
    }
    private String getUUIDFromJWT(String jwtToken) {
        if ("null".equals(jwtToken) || StringUtils.isBlank(jwtToken)) {
            return null;
        }
        Map<String, Object> jwtClaims = null;
        try {
            jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken).getBody();
            return MapUtils.getString(jwtClaims, LOGIN_USER_KEY);
        } catch (ExpiredJwtException e) {
            log.error("{}已过期", jwtToken);
        } catch (Exception e) {
            log.error("{}", e);
        }
        return null;
    }

    @Override
    public boolean deleteToken(String token) {
        String uuid = getUUIDFromJWT(token);
        if (uuid != null) {
            String key = getTokenKey(uuid);
            LoginUser loginUser = redisTemplate.opsForValue().get(key);
            if (loginUser != null) {
                redisTemplate.delete(key);
                // 退出日志
                return true;
            }
        }
        return false;
    }
}
