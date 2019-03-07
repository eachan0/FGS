package web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysOrder;
import system.entityExamplke.SysOrderExample;
import system.enums.ExcptionEnum;
import system.service.OrderService;
import system.utils.ResultVOUtil;

import java.util.ArrayList;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月07日 20:39
 * @desc OrderController 订单
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResultVO add(@RequestBody(required = false) ArrayList<SysOrder> list){
        if (list.size()<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        list.forEach(item->{
            if (item.getUserId()==null||item.getProId()==null){
                list.remove(item);
            }
        });
        return ResultVOUtil.sqlResult(orderService.add(list));
    }

    @DeleteMapping("/order")
    public ResultVO del(String orderNo){
        if (StringUtils.isNotBlank(orderNo)){
            return ResultVOUtil.sqlResult(orderService.del(orderNo));
        }
        return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
    }

    @PutMapping("/order")
    public ResultVO update(SysOrder order){
        if (order==null || order.getProId()==null){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(orderService.update(order));
    }

    @GetMapping("/orders")
    public ResultVO getOrders(Pagination pagination){
        SysOrderExample example = new SysOrderExample();
        example.createCriteria().andStatusEqualTo(1);
        return orderService.get(pagination,example);
    }

    @GetMapping("/order")
    public ResultVO getOrdersByUid(Integer uid){
        if (uid==null || uid<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        SysOrderExample example = new SysOrderExample();
        example.createCriteria().andStatusEqualTo(1).andUserIdEqualTo(uid);
        return orderService.get(null,example);
    }
}
