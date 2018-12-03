package system.utils;

import system.DO.ResultVO;

/**
 * @program: FGS
 * @description: 统一返回值工具类
 * @author: zhuyc
 * @create: 2018-12-03 17:21
 **/
public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
}
