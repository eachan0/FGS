package system.service;

import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysOrder;
import system.entityExamplke.SysOrderExample;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月07日 20:28
 * @desc OrderService 订单
 */
public interface OrderService {
    int add(List<SysOrder> order);
    int del(String orderNo);
    int update(SysOrder order);
    ResultVO get(Pagination pagination, SysOrderExample example);
}
