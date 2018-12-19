package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysUser;
import system.entityExamplke.SysUserExample;
import system.mapper.SysUserMapper;
import system.service.SysUserService;

import java.util.List;

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
        SysUserExample userExample = new SysUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List list = userMapper.selectByExample(userExample);
        return (SysUser) list.get(0);
    }
}
