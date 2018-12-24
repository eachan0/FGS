package system.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import system.entity.SysUser;

/**
 * @program: OSS
 * @description: 加密工具类
 * @author: zhuyc
 * @create: 2018-10-25 22:16
 **/
public class BCryptUtils {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String encoder(String pass){
        return passwordEncoder.encode(pass);
    }
    public static void encoder(SysUser user){
        if (StringUtils.isBlank(user.getPassword())){
            user.setPassword(user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    public static Boolean matches(String p1,String p2){
        return passwordEncoder.matches(p1,p2);
    }
}
