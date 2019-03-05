package system.mapper;

import org.apache.coyote.http11.OutputFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="zhuyichen@cqyyt.com">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月05日 20:51
 * @desc test
 */
public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.print(list.remove(0));
        System.out.print(list.toString());
    }
}
