package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.UserAddress;
import system.entityExamplke.UserAddressExample;
import system.mapper.UserAddressDao;
import system.service.UserAddressService;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月02日 21:55
 * @desc UserAddressServiceImpl
 */
@Service
@Transactional
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    UserAddressDao addressDao;

    @Override
    public int setAddress(UserAddress userAddress) {
        this.delAddress(userAddress.getUserId());
        return addressDao.insert(userAddress);
    }

    @Override
    public UserAddress getByUserId(Integer id) {
        return addressDao.getAddressById(id);
    }

    @Override
    public int delAddress(Integer id) {
        UserAddressExample userAddressExample = new UserAddressExample();
        userAddressExample.createCriteria().andUserIdEqualTo(id);
        return addressDao.deleteByExample(userAddressExample);
    }
}
