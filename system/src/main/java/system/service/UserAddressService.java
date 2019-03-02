package system.service;

import system.entity.UserAddress;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月02日 21:53
 * @desc UserAddressService 用户地址管理
 */
public interface UserAddressService {
    int setAddress(UserAddress userAddress);
    UserAddress getByUserId(Integer id);
    int delAddress(Integer id);
}
