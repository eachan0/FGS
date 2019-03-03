package system.service;

import system.DTO.Pagination;
import system.VO.ResultVO;
import system.entity.Product;
import system.entityExamplke.ProductExample;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月03日 18:11
 * @desc ProductService
 */
public interface ProductService {
    int add(Product product);
    int del(List<Integer> list);
    int put(Product product);
    ResultVO sel(Pagination pagination, ProductExample productExample);
}
