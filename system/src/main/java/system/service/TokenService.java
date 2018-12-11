package system.service;

import system.DTO.LoginUser;
import system.model.Token;

/**
 * Token管理器<br>
 * 可存储到redis或者数据库<br>
 * 具体可看实现类<br>
 * 默认基于redis，实现类为 com.boot.security.server.service.impl.TokenServiceJWTImpl<br>
 * 如要换成数据库存储，将TokenServiceImpl类上的注解@Primary挪到com.boot.security.server.service.impl.TokenServiceDbImpl
 * 
 * 
 * @author 小威老师
 *
 *         2017年10月14日
 */
public interface TokenService {

	Token saveToken(LoginUser user);

	void refresh(LoginUser user);

	LoginUser getLoginUser(String token);

	boolean deleteToken(String token);

}
