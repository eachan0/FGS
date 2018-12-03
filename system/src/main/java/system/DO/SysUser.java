package system.DO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;


@ToString
@Data
@Alias("user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = -4114504759037876295L;

    private Integer id;

    private String nickname;

    private String username;

    private String password;

    private String sex;

    private Boolean isExpired;

    private Boolean isLock;

    private Boolean isEnable;

    private Date crateTime;
}