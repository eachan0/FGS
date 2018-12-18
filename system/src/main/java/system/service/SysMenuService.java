package system.service;

import system.DO.SysMenu;

import java.util.List;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 11:53
 **/
public interface SysMenuService {
    List<SysMenu> getMenuListByUserName(String username);
    List<SysMenu> getMenuList();

    int deleteByPrimaryKey(Integer id);
    int insert(SysMenu menu);
    int insertSelective(SysMenu menu);
    int updateByPrimaryKeySelective(SysMenu menu);
    int updateByPrimaryKey(SysMenu menu);
}
