package system.VO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月05日 21:34
 * @desc ShopcarVO 购物车
 */
@Data
@ToString
public class ShopcarVO implements Serializable {
    private static final long serialVersionUID = 5013568142075084586L;

    private Integer userId;

    private Integer proId;

    private Double cjPrice;

    private Integer cjNum;

    private Double cjAmount;

    private String name;

    private String desc;

    private String photo;
}
