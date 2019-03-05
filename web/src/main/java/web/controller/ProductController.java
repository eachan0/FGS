package web.controller;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.FormProduct;
import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.Product;
import system.entityExamplke.ProductExample;
import system.enums.ExcptionEnum;
import system.service.ProductService;
import system.utils.BCryptUtils;
import system.utils.ResultVOUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月03日 18:06
 * @desc ProductController
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResultVO add(FormProduct product){
        if (product==null){
            return ResultVOUtil.error("参数错误");
        }
        Product product1 = new Product();
        BeanUtils.copyProperties(product,product1);
        product1.setPhoto(product.getBase64());
        return ResultVOUtil.sqlResult(productService.add(product1));
    }

    @DeleteMapping("/product")
    public ResultVO del(@RequestBody(required = false) List<Integer> ids){
        if (ids==null || ids.size()<=0){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
        return ResultVOUtil.sqlResult(productService.del(ids));
    }

    @PutMapping("/product")
    public ResultVO put(FormProduct product){
        if (product==null || product.getId()==null){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        try {
            Product product1 = new Product();
            BeanUtils.copyProperties(product,product1);
            if (product.getFile()!=null && product.getFile().getBytes().length>0){
                product1.setPhoto(product.getBase64());
            }
            return ResultVOUtil.sqlResult(productService.put(product1));
        } catch (IOException e) {
            return ResultVOUtil.error();
        }
    }

    @GetMapping("/product")
    public ResultVO sel(Pagination pagination,String name,Integer type){
        ProductExample example = new ProductExample();

        if (type!=null && type!=3){
            example.createCriteria().andStatusEqualTo(type);
        }else if (StringUtils.isNotBlank(name)){
            example.createCriteria().andNameLike("%"+name+"%");
        }else {
            example.createCriteria().andStatusIn(Arrays.asList(1,2));
        }
        return productService.sel(pagination,example);
    }
}
