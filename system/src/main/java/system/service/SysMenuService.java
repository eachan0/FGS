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
    List<SysMenu> getMenuList();

    int deleteByExample(List<Integer> list);
    int insert(SysMenu menu);
    int insertSelective(SysMenu menu);
    int updateByPrimaryKeySelective(SysMenu menu);
    int updateByPrimaryKey(SysMenu menu);
}
