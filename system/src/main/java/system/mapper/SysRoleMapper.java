/*
*
* SysRoleMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysRole;
import system.entity.SysRoleMenu;
import system.entityExamplke.SysRoleExample;

import java.util.ArrayList;
import java.util.List;

public interface SysRoleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(SysRole record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysRole record);

    /**
     *
     * @mbg.generated
     */
    List<SysRole> selectByExample(SysRoleExample example);

    /**
     *
     * @mbg.generated
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectByUsreId(Integer id);
}