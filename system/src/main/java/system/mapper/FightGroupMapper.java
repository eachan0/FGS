/*
*
* FightGroupMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-12
*/
package system.mapper;

import org.apache.ibatis.annotations.Param;
import system.entity.FightGroup;
import system.entityExamplke.FightGroupExample;

import java.util.List;

public interface FightGroupMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(FightGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(FightGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer proId);

    /**
     *
     * @mbg.generated
     */
    int insert(FightGroup record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(FightGroup record);

    /**
     *
     * @mbg.generated
     */
    List<FightGroup> selectByExample(FightGroupExample example);

    /**
     *
     * @mbg.generated
     */
    FightGroup selectByPrimaryKey(Integer proId);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") FightGroup record, @Param("example") FightGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") FightGroup record, @Param("example") FightGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FightGroup record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FightGroup record);
}
