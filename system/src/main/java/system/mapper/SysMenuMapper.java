package system.mapper;

import system.DO.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu menu);

    int insertSelective(SysMenu menu);

    int updateByPrimaryKeySelective(SysMenu menu);

    int updateByPrimaryKey(SysMenu menu);

    SysMenu selectByPrimaryKey(Integer id);
}