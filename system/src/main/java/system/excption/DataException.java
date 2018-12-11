package system.excption;

import lombok.Data;
import system.enums.ExcptionEnum;

/**
 * @program: FGS
 * @description: 数据异常
 * @author: zhuyc
 * @create: 2018-12-04 09:30
 **/
@Data
public class DataException extends RuntimeException {
    private static final long serialVersionUID = 5987808863530715675L;

    private Integer code;

    public DataException(String msg,Integer code){
        super(msg);
        this.code = code;
    }
    public DataException(ExcptionEnum excptionEnum){
        super(excptionEnum.getMsg());
        this.code = excptionEnum.getCode();
    }
}
