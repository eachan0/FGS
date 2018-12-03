package system.DO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@ToString
@Data
@Alias("rolemenu")
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 8464006478822002743L;

    private Integer id;

    private Integer roleId;

    private Integer menuId;
}