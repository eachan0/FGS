package system.service;

import system.DO.SysUser;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:38
 **/
public interface SysUserService {
    SysUser getUserByUserName(String username);
}
