package web.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.ShopCar;
import system.entityExamplke.ShopCarExample;
import system.enums.ExcptionEnum;
import system.service.ShopcarService;
import system.utils.ResultVOUtil;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月05日 20:58
 * @desc ShopcarController 购物车
 */
@RestController
@RequestMapping("/shopcar")
public class ShopcarController {

    @Autowired
    ShopcarService service;

    @PostMapping("/shopcar")
    public ResultVO add(@RequestBody ShopCar shopCar){
        if (shopCar==null || shopCar.getUserId()==null || shopCar.getProId()==null){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(service.add(shopCar));
    }

    @DeleteMapping("/shopcar")
    public ResultVO del(@RequestBody(required = false) List<Integer> ids){
        if (ids == null || ids.size()<2){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(service.del(ids));
    }

    @GetMapping("/shopcar")
    public ResultVO getShopcar(Pagination pagination, Integer uid){
        if (uid==null || uid<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }

        return service.getShopCar(null,uid);
    }
}
