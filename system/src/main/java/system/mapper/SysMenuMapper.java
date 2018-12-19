/*
*
* SysMenuMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysMenu;
import system.entityExamplke.SysMenuExample;

import java.util.List;

public interface SysMenuMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(SysMenu record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysMenu record);

    /**
     *
     * @mbg.generated
     */
    List<SysMenu> selectByExample(SysMenuExample example);

    /**
     *
     * @mbg.generated
     */
    SysMenu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysMenu record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getMenuListByUserName(String username);
}