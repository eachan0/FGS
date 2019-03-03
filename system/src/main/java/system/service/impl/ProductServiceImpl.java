package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.Product;
import system.entity.SysUser;
import system.entityExamplke.ProductExample;
import system.mapper.ProductMapper;
import system.service.ProductService;
import system.utils.PageUtils;
import system.utils.ResultVOUtil;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月03日 18:12
 * @desc ProductServiceImpl
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public int add(Product product) {
        return productMapper.insertSelective(product);
    }

    @Override
    public int del(List<Integer> list) {
        return productMapper.delByIdIn(list);
    }

    @Override
    public int put(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public ResultVO sel(Pagination pagination, ProductExample productExample) {

        if (PageUtils.isValid(pagination)) {
            PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
            List<Product> list = productMapper.selectByExample(productExample);
            PageInfo<Product> pageInfo = new PageInfo<>(list, pagination.getPageSize());
            return ResultVOUtil.success(pageInfo.getList(), (int) pageInfo.getTotal());
        } else {
            List list = productMapper.selectByExample(productExample);
            return ResultVOUtil.success(list, list.size());
        }
    }
}
