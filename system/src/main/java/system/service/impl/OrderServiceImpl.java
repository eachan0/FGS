package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.SysOrder;
import system.entityExamplke.SysOrderExample;
import system.mapper.SysOrderMapper;
import system.service.OrderService;
import system.service.ShopcarService;
import system.utils.PageUtils;
import system.utils.ResultVOUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月07日 20:31
 * @desc OrderServiceImpl
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    SysOrderMapper orderMapper;

    @Autowired
    ShopcarService shopcarService;

    @Override
    public int add(List<SysOrder> order) {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(order.get(0).getUserId());
        AtomicInteger result = new AtomicInteger();
        order.forEach(item->{
            item.setOrderNo(this.createOrderNo(item.getUserId()));
            ids.add(item.getProId());
            orderMapper.insertSelective(item);
            result.getAndIncrement();
        });
        System.out.println(order);
        shopcarService.del(ids);
        return result.intValue();
    }

    @Override
    public int del(String orderNo) {
        SysOrder order = new SysOrder();
        order.setOrderNo(orderNo);
        order.setStatus(0);
        return orderMapper.updateByPrimaryKeySelective(order);
    }
    protected String createOrderNo(Integer uid){
        String[] split = LocalTime.now().toString().split(":");
        StringBuilder orderNo = new StringBuilder();
        for (String str: LocalDate.now().toString().split("-")){
            orderNo.append(str);
        }
        orderNo.append(split[0]);
        orderNo.append(split[1]);
        orderNo.append(split[2].substring(3,6));
        orderNo.append(uid);
        return String.valueOf(orderNo);
    }

    @Override
    public int update(SysOrder order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public ResultVO get(Pagination pagination, SysOrderExample example) {
        if (PageUtils.isValid(pagination)) {
            PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
            List<SysOrder> list = orderMapper.selectByExample(example);
            PageInfo<SysOrder> pageInfo = new PageInfo<>(list, pagination.getPageSize());
            return ResultVOUtil.success(pageInfo.getList(), (int) pageInfo.getTotal());
        } else {
            List<SysOrder> list = orderMapper.selectByExample(example);
            return ResultVOUtil.success(list, list.size());
        }
    }
}
