package system.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import system.enums.ExcptionEnum;
import system.excption.DataException;
import system.utils.ResultVOUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: FGS
 * @description: 异常处理
 * @author: zhuyc
 * @create: 2018-12-04 09:22
 **/
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandle(HttpServletRequest request, Exception e) {

        if (e instanceof DataException) {
            DataException exception = (DataException) e;
            return ResultVOUtil.error(exception.getCode(), exception.getMessage());
        } else if(e instanceof AccessDeniedException){
            return ResultVOUtil.error(ExcptionEnum.Access_Denied);
        }
        else{
            log.info("[系统异常]{}", e);
            return ResultVOUtil.error(ExcptionEnum.SYSTEM_ERROR);
        }
    }

    /*
        通过请求头判断
        是否为ajax请求
     */
    private static boolean isAjax(HttpServletRequest request) {
        String handle = request.getHeader("X-Requested-With");
        return ("XMLHttpRequest".equals(handle));
    }
}
