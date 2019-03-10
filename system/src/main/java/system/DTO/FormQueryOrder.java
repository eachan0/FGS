package system.DTO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月10日 22:16
 * @desc FormQueryOrder 订单查询条件
 */
@Data
@ToString
public class FormQueryOrder implements Serializable {
    private static final long serialVersionUID = -8353201448844398554L;

    private String orderNo;
    private String schedule;
    private Date startDate;
    private Date endDate;
}
