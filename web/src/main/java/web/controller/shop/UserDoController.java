package web.controller.shop;

import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import system.DTO.FormUser;
import system.VO.ResultVO;
import system.entity.SysUser;
import system.entity.UserAddress;
import system.service.SysUserService;
import system.service.UserAddressService;
import system.utils.ResultVOUtil;
import web.utils.DateUtil;

import java.io.IOException;
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

    @GetMapping("/testurl1")
    public Object getData(@RequestParam(required = false) String str){
        return ResultVOUtil.success(str);
    }
    @PostMapping("/testurl2")
    public Object postData(@RequestParam(required = false) String name,@RequestParam MultipartFile file){
        BASE64Encoder base64Encoder =new BASE64Encoder();
        String base64EncoderImg = null;
        try {
            base64EncoderImg = IMG_TYPE+base64Encoder.encode(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.success(base64EncoderImg);
    }
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
