package web.controller.shop;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.DTO.FormUser;
import system.VO.ResultVO;
import system.entity.SysUser;
import system.entity.UserAddress;
import system.service.SysUserService;
import system.service.UserAddressService;
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

    private static final String IMG_TYPE = "data:image/jpeg;base64,";

    @Autowired
    SysUserService userService;

    @Autowired
    UserAddressService addressService;

    @PostMapping("/register")
    public Object register(@RequestBody(required = false) FormUser user){
        if (user!=null){
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(user,sysUser);
            sysUser.setIsEnable(true);
            sysUser.setIsExpired(true);
            sysUser.setIsLock(true);
            sysUser.setCrateTime(new Date());
            return ResultVOUtil.sqlResult(userService.insert(sysUser));
        }
        return ResultVOUtil.error();
    }
    @PostMapping("/putinfo")
    public ResultVO putinfo(@RequestBody(required = false) SysUser user){
        if (user==null || user.getId()==null){
            return ResultVOUtil.error("修改失败");
        }
        return ResultVOUtil.sqlResult(userService.updateByPrimaryKeySelective(user));
    }

    @PostMapping("/address")
    public ResultVO addAddress(@RequestBody(required = false)UserAddress address){
        if (address==null || address.getUserId()==null){
            return ResultVOUtil.error("参数错误");
        }
        return ResultVOUtil.sqlResult(addressService.setAddress(address));
    }
    @GetMapping("/address/{id}")
    public ResultVO getAddress(@PathVariable(required = false) Integer id){
        if (id==null || id<0){
            ResultVOUtil.error();
        }
        return ResultVOUtil.success(addressService.getByUserId(id));
    }
}
