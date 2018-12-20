package web.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import system.VO.ResultVO;
import system.enums.ExcptionEnum;
import system.utils.ResultVOUtil;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 12:52
 * @desc BindingResultMsg
 */
public class BindingResultMsg {
    public static ResultVO getErrorMsg(BindingResult result){
        StringBuilder err = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            err.append(error.getDefaultMessage());
        }
        return ResultVOUtil.error(ExcptionEnum.PARAM_ERROR,err.toString());
    }
}
