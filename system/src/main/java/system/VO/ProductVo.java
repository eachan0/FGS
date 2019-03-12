package system.VO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import system.entity.Product;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月12日 22:59
 * @desc ProductVo
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ProductVo extends Product implements Serializable {
    private static final long serialVersionUID = 4385465378006180335L;
    /**
     * 商品编号
     */
    private Integer proId;

    /**
     * 总人数
     */
    private Integer totalNum;

    /**
     * 当前人数
     */
    private Integer currentNum;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
