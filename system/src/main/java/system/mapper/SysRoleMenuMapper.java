/*
*
* SysRoleMenuMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysRoleMenu;
import system.entityExamplke.SysRoleMenuExample;

import java.util.List;

public interface SysRoleMenuMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(SysRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    SysRoleMenu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRoleMenu record);

    Integer insertBatch(List<SysRoleMenu> list);
}