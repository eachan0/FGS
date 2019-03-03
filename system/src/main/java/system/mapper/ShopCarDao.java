package system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import system.entity.ShopCar;
import system.entityExamplke.ShopCarExample;

public interface ShopCarDao {
    long countByExample(ShopCarExample example);

    int deleteByExample(ShopCarExample example);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    List<ShopCar> selectByExample(ShopCarExample example);

    int updateByExampleSelective(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    int updateByExample(@Param("record") ShopCar record, @Param("example") ShopCarExample example);
}
