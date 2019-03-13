/*
*
* FgedMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-13
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.Fged;
import system.entityExamplke.FgedExample;

import java.util.List;

public interface FgedMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(FgedExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(FgedExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated
     */
    int insert(Fged record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Fged record);

    /**
     *
     * @mbg.generated
     */
    List<Fged> selectByExample(FgedExample example);

    /**
     *
     * @mbg.generated
     */
    Fged selectByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Fged record, @Param("example") FgedExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Fged record, @Param("example") FgedExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Fged record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Fged record);
}
