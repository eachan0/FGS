package system.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import system.entity.SysUser;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月20日 22:04
 * @desc FormUser
 */
@Data
@ToString
public class FormUser implements Serializable {
    private static final long serialVersionUID = 7689213288929736707L;
    private List<Integer> roles;
    private Boolean isLock;
    private String nickname;
    private String password;
    private String sex;
    @NotNull(message = "账户不能为空")
    private String username;
}
