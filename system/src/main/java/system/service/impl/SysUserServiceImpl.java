package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DO.SysUser;
import system.mapper.SysUserMapper;
import system.service.SysUserService;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:39
 **/
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper userMapper;

    @Override
    public SysUser getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
