package pri.zxx.learndemo.threademo.juc;

import java.util.Random;

/**
 * @author Twilight
 * @desc ThreadLocalRandom demo
 * @createTime 2019-06-09-22:04
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
