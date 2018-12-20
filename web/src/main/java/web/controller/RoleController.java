package web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import system.VO.ResultVO;
import system.entity.SysRole;
import system.entityExamplke.SysRoleExample;
import system.enums.ExcptionEnum;
import system.service.SysRoleService;
import system.utils.ResultVOUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 13:18
 * @desc RoleController
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    SysRoleService roleService;

    @ApiOperation(value = "添加角色")
    @ApiImplicitParam(name = "role",value = "角色",required = true,paramType = "JsonString")
    @PostMapping("/role")
    @PreAuthorize("hasAnyAuthority('sys:role:add')")
    public ResultVO addRole(@Valid @RequestBody SysRole role, BindingResult result){
        if (result.hasErrors()){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
        return ResultVOUtil.sqlResult(roleService.insertSelective(role));
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(name = "ids",value = "角色id数组",required = true,paramType = "JsonString")
    @DeleteMapping("/role")
    @PreAuthorize("hasAnyAuthority('sys:role:del')")
    public ResultVO delRole(@RequestBody(required = false) List<Integer> ids){
        if ((ids == null) || (ids.size() <= 0)){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIdIn(ids);
        return ResultVOUtil.sqlResult(roleService.deleteByExample(roleExample));
    }

    @ApiOperation(value = "修改角色")
    @ApiImplicitParam(name = "role",value = "角色",required = true,paramType = "JsonString")
    @PutMapping("/role")
    @PreAuthorize("hasAnyAuthority('sys:role:update')")
    public ResultVO putRole(@RequestBody(required = false)SysRole role){
        if ((role == null) || (role.getId() == null) || (role.getId() <= 0)){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(roleService.updateByPrimaryKeySelective(role));
    }

    @ApiOperation(value = "查询角色列表")
    @GetMapping("/roles")
    @PreAuthorize("hasAnyAuthority('sys:role:select')")
    public ResultVO getRoleList(){
        List<SysRole> sysRoles = roleService.selectByExample(null);
        return ResultVOUtil.success(sysRoles,sysRoles.size());
    }
}
