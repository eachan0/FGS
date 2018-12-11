package web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import system.DO.ResultVO;
import system.utils.ResultVOUtil;

/**
 * @program: FGS
 * @description: 测试Nginx的反向代理
 * @author: zhuyc
 * @create: 2018-12-03 17:15
 **/
@RestController
public class NginxTestController {
    @ApiOperation(value = "nginx测试接口",notes = "...")
    @GetMapping("/test")
    public ResultVO test(){
        int i =1/0;
        return ResultVOUtil.success();
    }
}
