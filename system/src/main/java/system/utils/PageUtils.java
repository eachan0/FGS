package system.utils;

import system.DTO.Pagination;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2018年12月24日 14:28
 * @desc PageUtils
 */
public class PageUtils {
    public static Boolean isValid(Pagination pagination){
        if (pagination==null){
            return false;
        }
        if (pagination.getPage()==null||pagination.getPage()<1){
            return false;
        }
        return pagination.getPageSize() != null && pagination.getPageSize() >= 1;
    }
}
