package system.service;

import system.entity.SysRole;
import system.entityExamplke.SysRoleExample;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 13:03
 * @desc SysRoleService
 */
public interface SysRoleService {
    int insertSelective(SysRole record);
    int deleteByExample(SysRoleExample example);
    int updateByPrimaryKeySelective(SysRole record);
    List<SysRole> selectByExample(SysRoleExample example);
    List<SysRole> selectByUsreId(Integer id);
}
