package web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年02月27日 20:28
 * @desc DateUtil 获取时间
 */
public class DateUtil {
    public static String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
