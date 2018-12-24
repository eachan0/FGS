package web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import system.entity.SysMenu;
import system.VO.ResultVO;
import system.entityExamplke.SysMenuExample;
import system.entityExamplke.SysRoleMenuExample;
import system.enums.ExcptionEnum;
import system.service.SysMenuService;
import system.service.SysRoleMenuService;
import system.utils.ResultVOUtil;
import web.utils.BindingResultMsg;

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
    @Autowired
    private SysRoleMenuService roleMenuService;

    @ApiOperation(value = "获取菜单列表",notes = "admin")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:menu:select')")
    public ResultVO getMenuList(){
        List<SysMenu> list =  menuService.selectByExample(null);
        return ResultVOUtil.success(list,list.size());
    }

    @ApiOperation(value = "增加菜单")
    @ApiImplicitParam(name = "menu",value = "菜单",required = true,paramType = "JsonString")
    @PostMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:add')")
    public ResultVO addMenu(@Valid @RequestBody SysMenu menu, BindingResult result){
        if (result.hasErrors()) {
           return BindingResultMsg.getErrorMsg(result);
        }
        return ResultVOUtil.sqlResult(menuService.insertSelective(menu));
    }

    @ApiOperation(value = "删除菜单")
    @ApiImplicitParam(name = "ids",value = "id数组",required = true,paramType = "JsonString")
    @DeleteMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:del')")
    public ResultVO delMenu(@RequestBody(required = false) List<Integer> ids){
        if ((ids == null) || (ids.size() <= 0)){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
//        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
//        roleMenuExample.createCriteria().andMenuIdIn(ids);
//        roleMenuService.deleteByExample(roleMenuExample);
//        SysMenuExample menuExample = new SysMenuExample();
//        menuExample.createCriteria().andIdIn(ids);
//      eturn ResultVOUtil.sqlResult(menuService.deleteByExample(menuExample));
        return ResultVOUtil.success(ids);
    }

    @ApiOperation(value = "修改菜单")
    @ApiImplicitParam(name = "menu",value = "菜单",required = true,paramType = "JsonString")
    @PutMapping("/menu")
    @PreAuthorize("hasAnyAuthority('sys:menu:update')")
    public ResultVO putMenu(@RequestBody(required = false) SysMenu menu){
        if ((menu == null) || (menu.getId() == null) || (menu.getId() <= 0)){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(menuService.updateByPrimaryKeySelective(menu));
    }
}
