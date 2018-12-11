package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.LoginUser;
import system.model.Token;
import system.service.TokenService;

import java.security.Key;
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
        return null;
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

    }

    @Override
    public LoginUser getLoginUser(String token) {
        return null;
    }

    @Override
    public boolean deleteToken(String token) {
        return false;
    }
}
