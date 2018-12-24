package system.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月21日 11:03
 * @desc CurrentTime
 */
public class CurrentTime {
    public static Date getCurrentTime(String format){
        Date time = null;
        if (StringUtils.isBlank(format)){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
           time = sdf.parse(sdf.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
            time = new Date();
        }
        return time;
    }
}
