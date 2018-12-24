package system.DTO;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月21日 17:06
 * @desc Pagination
 */

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pagination {
    private Integer page;
    private Integer pageSize;
}
