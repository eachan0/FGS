/*
*
* SysUserRoleMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysUserRole;
import system.entityExamplke.SysUserRoleExample;

import java.util.List;

public interface SysUserRoleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(SysUserRole record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysUserRole record);

    /**
     *
     * @mbg.generated
     */
    List<SysUserRole> selectByExample(SysUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    SysUserRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysUserRole record);
}