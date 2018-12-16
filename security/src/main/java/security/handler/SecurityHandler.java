package security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import security.filter.TokenFilter;
import system.DTO.LoginUser;
import system.DTO.ResponseInfo;
import system.model.Token;
import system.service.TokenService;
import system.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security处理器
 * 
 * @author 小威老师
 *
 *         2017年10月16日
 */
@Configuration
public class SecurityHandler {

	@Autowired
	private TokenService tokenService;

	/**
	 * 登陆成功，返回Token
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				LoginUser user = (LoginUser) authentication.getPrincipal();
				Token token = tokenService.saveToken(user);
				ResponseUtil.responseJson(response, HttpStatus.OK.value(), token);
			}
		};
	}

	/**
	 * 登陆失败
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationFailureHandler loginFailureHandler() {
		return new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {

				String message;
				if (exception instanceof UsernameNotFoundException) {
					message = "用户不存在！";
				} else if (exception instanceof BadCredentialsException) {
					message = "用户名或密码错误！";
				} else if (exception instanceof LockedException) {
					message = "用户被锁定!";
				} else if (exception instanceof DisabledException) {
					message = "用户不可用！请查看审核信息";
				} else if (exception instanceof AccountExpiredException) {
					message = "账户已过期！";
				} else if (exception instanceof CredentialsExpiredException) {
					message = "用户密码已过期！";
				} else {
					message = "认证失败，请联系网站管理员！";
				}
				ResponseInfo info = new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", message);
				ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
			}
		};

	}

	/**
	 * 未登录，返回401
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {

			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				ResponseInfo info = new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", "请先登录");
				ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
			}
		};
	}

	/**
	 * 退出处理
	 * 
	 * @return
	 */
	@Bean
	public LogoutSuccessHandler logoutSussHandler() {
		return new LogoutSuccessHandler() {
			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				ResponseInfo info = new ResponseInfo(HttpStatus.OK.value() + "", "退出成功");
				String token = TokenFilter.getToken(request);
				tokenService.deleteToken(token);
				ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
			}
		};

	}

}
