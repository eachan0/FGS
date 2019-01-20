package system.service;

import system.entity.SysMenu;
import system.entityExamplke.SysMenuExample;

import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:53
 **/
public interface SysMenuService {
    List<SysMenu> getMenuListByUserName(String username);

    int insertSelective(SysMenu menu);
    int deleteByExample(SysMenuExample example);
    int updateByPrimaryKeySelective(SysMenu menu);
    List<SysMenu> selectByExample(SysMenuExample example);

    List<SysMenu> getMenuByRoleId(Integer id);
}
