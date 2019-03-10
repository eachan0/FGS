package system.DTO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月10日 23:20
 * @desc FormQueryUser 用户查询
 */
@ToString
@Data
public class FormQueryUser implements Serializable {
    private static final long serialVersionUID = -2212082574726905665L;
    private Boolean isLock;
    private String nickname;
    private String username;
    private Date startDate;
    private Date endDate;
}
