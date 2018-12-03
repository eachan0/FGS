package system.DO;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@ToString
@Data
@Alias("menu")
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 6333793973233996828L;

    private Integer id;

    private String menuName;

    private String url;

    private String type;

    private String ico;

    private Integer sort;

    private String permission;

    private Integer parentid;
}