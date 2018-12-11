package system.utils;

import system.DO.ResultVO;
import system.enums.ExcptionEnum;

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
    public static ResultVO error(){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(1);
        resultVO.setMsg("errot");
        resultVO.setData(null);
        return resultVO;
    }
    public static ResultVO error(Integer code ,String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }
    public static ResultVO error(ExcptionEnum excptionEnum){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(excptionEnum.getCode());
        resultVO.setMsg(excptionEnum.getMsg());
        resultVO.setData(null);
        return resultVO;
    }
}
