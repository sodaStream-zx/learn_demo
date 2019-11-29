package pri.zxx.learndemo.justTest;

import java.util.HashSet;

/**
 * @author zxx
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
        long ob = 1L;
        boolean contains = se.contains(Long.toString(ob));
        System.out.println(contains);
    }
}
