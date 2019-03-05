package system.service;

import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.ShopCar;
import system.entityExamplke.ShopCarExample;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月05日 20:44
 * @desc ShopcarService 购物车
 */
public interface ShopcarService {
    int add(ShopCar shopCar);
    int del(List<Integer> ids);
    ResultVO getShopCar(Pagination pagination, Integer uid);
}
