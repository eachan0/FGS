package web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.VO.ResultVO;
import system.entityExamplke.SysRoleMenuExample;
import system.enums.ExcptionEnum;
import system.service.SysRoleMenuService;
import system.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年01月20日 21:05
 * @desc RoleMenucontroller
 */
@RestController
@RequestMapping("/rolemenu")
public class RoleMenuController {
    @Autowired
    SysRoleMenuService roleMenuService;

    @PutMapping("/rm")
    @ApiImplicitParam(name = "ids",value = "id数组",required = true,paramType = "Array")
    @PreAuthorize("hasAnyAuthority('sys:role:update')")
    public ResultVO putRoleMenu(@RequestBody(required = false) ArrayList<Integer> list){
        if (list==null || list.size()<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
        roleMenuExample.createCriteria().andRoleIdEqualTo(list.get(list.size()-1));
        if (list.size()==1){
            return ResultVOUtil.sqlResult(roleMenuService.deleteByExample(roleMenuExample));
        }
        roleMenuService.deleteByExample(roleMenuExample);
        return ResultVOUtil.sqlResult(roleMenuService.add(list));
    }
}
