package pri.zxx.learndemo.collectionDemo;

import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-23-21:12
 */
public class CharTest {
    public static void main(String[] args) {
        String str = "[[1,2],[3,5,8],[6,9]]";
        Stream.of(str.split(","))
                .filter(s -> s.contains("]"))
                .map(s -> s.replaceAll("\\]", ""))
                .forEach(System.out::println);
    }
}
