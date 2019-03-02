package system.DTO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月02日 19:56
 * @desc FormPass
 */
@Data
@ToString
public class FormPass implements Serializable {
    private static final long serialVersionUID = 5608457738629161863L;

    private String oldPass;
    private String newPass;
    private String rePass;
}
