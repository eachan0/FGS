package system.mapper;

import system.DO.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu menu);

    int insertSelective(SysMenu menu);

    int updateByPrimaryKeySelective(SysMenu menu);

    int updateByPrimaryKey(SysMenu menu);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu> getMenuListByUserName(String username);
}