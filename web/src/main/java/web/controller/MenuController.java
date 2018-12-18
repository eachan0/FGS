package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import system.DO.SysMenu;
import system.VO.ResultVO;
import system.enums.ExcptionEnum;
import system.service.SysMenuService;
import system.utils.ResultVOUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月18日 11:26
 * @desc MenuController
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private SysMenuService menuService;

    @PostMapping("/list")
    public ResultVO getMenuList(){
        List<SysMenu> list =  menuService.getMenuList();
        return ResultVOUtil.success(list,list.size());
    }

    @PostMapping("/menu")
    public ResultVO addMenu(@Valid SysMenu menu, BindingResult result){
        if (result.hasErrors()) {
           return getErrorMsg(result);
        }
        return ResultVOUtil.sqlResult(menuService.insertSelective(menu));
    }

    @DeleteMapping("/menu")
    public ResultVO delMenu(Integer id){
        if (id==null  || id<0 ){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
        return ResultVOUtil.sqlResult(menuService.deleteByPrimaryKey(id));
    }

    @PutMapping("/menu")
    public ResultVO putMenu(@Valid @RequestBody SysMenu menu, BindingResult result){
        if (result.hasErrors()) {
            return getErrorMsg(result);
        }
        if (menu.getId()==null || menu.getId()<0){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(menuService.updateByPrimaryKeySelective(menu));
    }

    private ResultVO getErrorMsg(BindingResult result){
        StringBuilder err = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            err.append(error.getDefaultMessage());
        }
        return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR,err.toString());
    }
}
