package system.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import system.entity.Product;
import system.excption.DataException;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月03日 18:04
 * @desc FormProduct
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormProduct extends Product{
    private static final String IMG_TYPE = "data:image/jpeg;base64,";
    private static final long serialVersionUID = 7340163828590451251L;
    MultipartFile file;
    public String getBase64(){
        BASE64Encoder base64Encoder =new BASE64Encoder();
        String base64EncoderImg = null;
        try {
            if (file.getBytes().length<1){
                throw new DataException("图片错误",-1);
            }
            base64EncoderImg = IMG_TYPE+base64Encoder.encode(file.getBytes());
        } catch (IOException e) {
            throw new DataException("图片错误",-1);
        }
        return base64EncoderImg;
    }
 }
