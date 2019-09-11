package pri.zxx.learndemo.my;

import java.util.HashSet;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-08-22-上午 10:48
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> se = new HashSet<>();
        se.add("1");
        se.add("2");
        se.add("3");
        se.add("4");
        se.add("5");
        Long ob = new Long(1);
        boolean contains = se.contains(ob.toString());
        System.out.println(contains);
    }
}
