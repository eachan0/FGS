package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import system.VO.ResultVO;
import system.utils.ResultVOUtil;

/**
 * @program: FGS
 * @description: 测试Nginx的反向代理
 * @author: zhuyc
 * @create: 2018-12-03 17:15
 **/
@RestController
public class TokenIsValid {
    @ApiOperation(value = "token有效验证接口",notes = "验证请求头中的token是否由本服务器发布!")
    @GetMapping("/tokenIsValid")
    public ResultVO tokenIsValid(){
        return ResultVOUtil.success();
    }
}
