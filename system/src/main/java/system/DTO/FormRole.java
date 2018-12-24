package system.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import system.entity.SysRole;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月24日 23:42
 * @desc FormRole
 */
@Data
@ToString
public class FormRole{
    private static final long serialVersionUID = -1325506101361452847L;
    List<Integer> menus;
    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String roleName;
}
