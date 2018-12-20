/*
*
* SysUserMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysUser;
import system.entityExamplke.SysUserExample;

import java.util.List;

public interface SysUserMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysUserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysUserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(SysUser record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysUser record);

    /**
     *
     * @mbg.generated
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     *
     * @mbg.generated
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysUser record);

    int updatePwdByIds(List<SysUser> list);
}