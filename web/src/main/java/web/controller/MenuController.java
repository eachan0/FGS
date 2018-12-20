package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import system.entity.SysMenu;
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

    @ApiOperation(value = "获取菜单列表",notes = "admin")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:menu:select')")
    public ResultVO getMenuList(){
        List<SysMenu> list =  menuService.getMenuList();
        return ResultVOUtil.success(list,list.size());
    }

    @ApiOperation(value = "增加菜单",notes = "admin")
    @ApiImplicitParam(name = "menu",value = "菜单",required = true,dataType = "JsonString",paramType = "RequestBody")
    @PostMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:add')")
    public ResultVO addMenu(@Valid @RequestBody SysMenu menu, BindingResult result){
        if (result.hasErrors()) {
           return getErrorMsg(result);
        }
        return ResultVOUtil.sqlResult(menuService.insertSelective(menu));
    }

    @ApiOperation(value = "删除菜单",notes = "admin")
    @ApiImplicitParam(name = "ids",value = "id数组",required = false,dataType = "JsonString",paramType = "RequestBody")
    @DeleteMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:del')")
    public ResultVO delMenu(@RequestBody(required = false) List<Integer> ids){
        if (ids==null  || ids.size()==0 ){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
        return ResultVOUtil.sqlResult(menuService.deleteByExample(ids));
    }

    @ApiOperation(value = "修改菜单",notes = "admin")
    @ApiImplicitParam(name = "menu",value = "菜单",required = true,dataType = "JsonString",paramType = "RequestBody")
    @PutMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:update')")
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
