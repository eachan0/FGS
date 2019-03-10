package web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.FormQueryOrder;
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
    public ResultVO add(@RequestBody(required = false) ArrayList<SysOrder> list) {
        if (list.size() < 1) {
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        list.forEach(item -> {
            if (item.getUserId() == null || item.getProId() == null) {
                list.remove(item);
            }
        });
        return ResultVOUtil.sqlResult(orderService.add(list));
    }

    @DeleteMapping("/order")
    public ResultVO del(@RequestParam String orderNo) {
        if (StringUtils.isNotBlank(orderNo)) {
            return ResultVOUtil.sqlResult(orderService.del(orderNo));
        }
        return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
    }

    @PutMapping("/order")
    public ResultVO update(@RequestBody(required = false) SysOrder order) {
        if (order == null || order.getOrderNo() == null) {
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(orderService.update(order));
    }

    @GetMapping("/orders")
    public ResultVO getOrders(Pagination pagination, FormQueryOrder queryOrder) {
        SysOrderExample example = new SysOrderExample();
        SysOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if (StringUtils.isNotBlank(queryOrder.getOrderNo())) {
            criteria.andOrderNoLike("%" + queryOrder.getOrderNo() + "%");
        }
        if (StringUtils.isNotBlank(queryOrder.getSchedule())) {
            criteria.andScheduleEqualTo(queryOrder.getSchedule());
        }
        if (queryOrder.getStartDate() != null && queryOrder.getEndDate() != null) {
            criteria.andCreateTimeBetween(queryOrder.getStartDate(), queryOrder.getEndDate());
        } else {
            if (queryOrder.getStartDate() != null) {
                criteria.andCreateTimeGreaterThanOrEqualTo(queryOrder.getStartDate());
            }
            if (queryOrder.getEndDate() != null) {
                criteria.andCreateTimeLessThanOrEqualTo(queryOrder.getEndDate());
            }
        }
        return orderService.get(pagination, example);
    }

    @GetMapping("/order")
    public ResultVO getOrdersByUid(Integer uid) {
        if (uid == null || uid < 1) {
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        SysOrderExample example = new SysOrderExample();
        example.createCriteria().andStatusEqualTo(1).andUserIdEqualTo(uid);
        return orderService.get(null, example);
    }
}
