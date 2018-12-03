package system.DO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@ToString
@Data
@Alias("role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 6729769465994210937L;

    private Integer id;

    private String roleName;

    private Boolean isEnable;
}