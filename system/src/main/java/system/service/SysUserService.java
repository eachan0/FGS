package system.service;

import system.entity.SysUser;
import system.entityExamplke.SysUserExample;

import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:38
 **/
public interface SysUserService {
    SysUser getUserByUserName(String username);
    int insertSelective(SysUser record);
    int deleteByExample(SysUserExample example);
    int updateByPrimaryKeySelective(SysUser record);
    List<SysUser> selectByExample(SysUserExample example);
}
