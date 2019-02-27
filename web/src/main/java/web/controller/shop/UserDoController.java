package web.controller.shop;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.FormUser;
import system.entity.SysUser;
import system.service.SysUserService;
import system.utils.ResultVOUtil;

import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年02月26日 12:39
 * @desc UserDoController 用户操作控制器
 */
@RestController
@RequestMapping("/shop")
public class UserDoController {

    @Autowired
    SysUserService userService;

    @GetMapping("/testurl1")
    public Object getData(@RequestParam(required = false) String str){
        return ResultVOUtil.success(str);
    }
    @PostMapping("/register")
    public Object postData(@RequestBody(required = false) FormUser user){
        if (user!=null){
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(user,sysUser);
            sysUser.setIsEnable(true);
            sysUser.setIsExpired(true);
            sysUser.setIsLock(true);
            sysUser.setCrateTime(new Date());
            return ResultVOUtil.sqlResult(userService.insert(null));
        }
        return ResultVOUtil.error();
    }
}
