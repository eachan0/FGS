package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.VO.ShopcarVO;
import system.entity.Product;
import system.entity.ShopCar;
import system.entityExamplke.ShopCarExample;
import system.mapper.ShopCarMapper;
import system.service.ShopcarService;
import system.utils.PageUtils;
import system.utils.ResultVOUtil;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月05日 20:46
 * @desc ShopcarServiceImpl
 */
@Service
@Transactional
public class ShopcarServiceImpl implements ShopcarService {

    @Autowired
    ShopCarMapper mapper;

    @Override
    public int add(ShopCar shopCar) {
        return mapper.insertSelective(shopCar);
    }

    @Override
    public int del(List<Integer> ids) {
        ShopCarExample example = new ShopCarExample();
        example.createCriteria().andUserIdEqualTo(ids.remove(0)).andProIdIn(ids);
        return mapper.deleteByExample(example);
    }

    @Override
    public ResultVO getShopCar(Pagination pagination,Integer uid) {
        if (PageUtils.isValid(pagination)) {
            PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
            List<ShopcarVO> list = mapper.getShopcarVO(uid);
            PageInfo<ShopcarVO> pageInfo = new PageInfo<>(list, pagination.getPageSize());
            return ResultVOUtil.success(pageInfo.getList(), (int) pageInfo.getTotal());
        } else {
            List list = mapper.getShopcarVO(uid);
            return ResultVOUtil.success(list, list.size());
        }
    }
}
