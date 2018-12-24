package system.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import system.entity.SysUser;
import system.DTO.LoginUser;
import system.service.SysMenuService;
import system.service.SysUserService;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 17:20
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService userService;

    @Autowired
    SysMenuService menuService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getUserByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user,loginUser);
        loginUser.setMenus(menuService.getMenuListByUserName(username));
        return loginUser;
    }
}
