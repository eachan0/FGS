/*
*
* SysOrderMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-07
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.SysOrder;
import system.entityExamplke.SysOrderExample;


import java.util.List;

public interface SysOrderMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysOrderExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysOrderExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String orderNo);

    /**
     *
     * @mbg.generated
     */
    int insert(SysOrder record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysOrder record);

    /**
     *
     * @mbg.generated
     */
    List<SysOrder> selectByExample(SysOrderExample example);

    /**
     *
     * @mbg.generated
     */
    SysOrder selectByPrimaryKey(String orderNo);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysOrder record, @Param("example") SysOrderExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysOrder record, @Param("example") SysOrderExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysOrder record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysOrder record);
}
