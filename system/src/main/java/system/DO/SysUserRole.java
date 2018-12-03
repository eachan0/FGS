package system.DO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@ToString
@Data
@Alias("userrole")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -5088715754116998887L;

    private Integer id;

    private Integer userId;

    private Integer roleId;
}