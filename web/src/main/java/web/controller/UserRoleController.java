package web.controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.VO.ResultVO;
import system.enums.ExcptionEnum;
import system.service.SysUserRoleService;
import system.utils.ResultVOUtil;

import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月21日 15:51
 * @desc UserRoleController
 */
@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    SysUserRoleService userRoleService;

    @PutMapping("/ur")
    public ResultVO put(@RequestBody(required = false)List<Integer> list){
        if (list==null || list.size()<1){
            return ResultVOUtil.error(ExcptionEnum.DATA_NULL);
        }
        return ResultVOUtil.sqlResult(userRoleService.delByUserId(list));
    }
}
