package system.DO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;


@ToString
@Data
@Alias("user")
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -4114504759037876295L;

    private Integer id;

    private String nickname;

    private String username;

    @JsonIgnore
    private String password;

    private String sex;
    @JsonIgnore
    private Boolean isExpired;
    @JsonIgnore
    private Boolean isLock;
    @JsonIgnore
    private Boolean isEnable;
    @JsonFormat(pattern = "yy-MM-dd")
    private Date crateTime;
}