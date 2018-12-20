package web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import system.VO.ResultVO;
import system.entity.SysUser;
import system.entityExamplke.SysUserExample;
import system.enums.ExcptionEnum;
import system.service.SysUserService;
import system.utils.ResultVOUtil;
import web.utils.BindingResultMsg;

import javax.validation.Valid;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 11:45
 * @desc UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    SysUserService userService;

    @ApiOperation(value = "查询用户")
    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('sys:user:select')")
    public ResultVO getUser(){
        List<SysUser> list = userService.selectByExample(null);
        return ResultVOUtil.success(list,list.size());
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user",value = "用户",required = true,paramType = "JsonString")
    @PostMapping("/user")
    @PreAuthorize("hasAnyAuthority('sys:user:add')")
    public ResultVO addUser(@Valid @RequestBody SysUser user, BindingResult result){
        if (result.hasErrors()) {
            return BindingResultMsg.getErrorMsg(result);
        }
        return ResultVOUtil.sqlResult(userService.insertSelective(user));
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "ids",value = "用户id数组",required = true,paramType = "JsonString")
    @DeleteMapping("/user")
    @PreAuthorize("hasAnyAuthority('sys:user:del')")
    public ResultVO delUser(@RequestBody(required = false) List<Integer> ids){
        if (ids==null || ids.size()<=0){
            return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR);
        }
//        SysUserExample userExample = new SysUserExample();
//        userExample.createCriteria().andIdIn(ids);
//        return ResultVOUtil.sqlResult(userService.deleteByExample(userExample));
        return ResultVOUtil.success(ids);
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParam(name = "user",value = "用户",required = true,paramType = "JsonString")
    @PutMapping("/user")
    @PreAuthorize("hasAnyAuthority('sys:user:update')")
    public ResultVO putUser(@RequestBody(required = false) SysUser user){
        if (user==null || user.getId()==null || user.getId()<=0){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(userService.updateByPrimaryKeySelective(user));
    }

    @ApiOperation(value = "修改用户密码")
    @ApiImplicitParam(name = "user",value = "用户",required = true,paramType = "JsonString")
    @PostMapping("/reset")
    @PreAuthorize("hasAnyAuthority('sys:user:update')")
    public ResultVO reset(@RequestBody(required = false) List<SysUser> list){
        if (list == null || list.size()<=0){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.success(userService.resetPwd(list));
    }
}
