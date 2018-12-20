package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysUser;
import system.entityExamplke.SysUserExample;
import system.mapper.SysUserMapper;
import system.service.SysUserService;
import system.utils.BCryptUtils;

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

    @Override
    public int insertSelective(SysUser record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int resetPwd(List<SysUser> list) {
        list.forEach(i->{
            i.setPassword(BCryptUtils.encoder(i.getUsername()+"fgs"));
        });
        return userMapper.updatePwdByIds(list);
    }
}
