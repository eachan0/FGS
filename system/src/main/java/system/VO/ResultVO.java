package system.VO;

import lombok.Data;
import lombok.ToString;

/**
 * @program: FGS
 * @description: 统一返回类型
 * @author: zhuyc
 * @create: 2018-12-03 17:18
 **/
@Data
@ToString
public class ResultVO<T> {
    Integer code;
    String msg;
    T data;
}
