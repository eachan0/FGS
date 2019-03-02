package system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import system.entity.UserAddress;
import system.entityExamplke.UserAddressExample;

public interface UserAddressDao {
    long countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExampleWithBLOBs(UserAddressExample example);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExampleWithBLOBs(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKeyWithBLOBs(UserAddress record);

    UserAddress getAddressById(Integer id);
}
