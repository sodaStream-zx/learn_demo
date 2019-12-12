package pri.zxx.learndemo.collectiondemo;

import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-23-21:12
 */
public class CharTest {
    public static void main(String[] args) {
        Object a = 0;
        System.out.println(ObjectUtils.isEmpty(a));
    }

    private static long getFireTme() {
        LocalDateTime nowMonth = LocalDateTime.now();
        LocalDateTime netMonth = nowMonth.plusMonths(1L);

        Duration between = Duration.between(nowMonth, netMonth);
        return between.toDays();
    }
}
