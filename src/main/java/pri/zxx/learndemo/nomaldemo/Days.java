package pri.zxx.learndemo.nomaldemo;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-03-25-下午 3:06
 */
public class Days {
    @Test
    public void getDay() {
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getMonth().maxLength());
        System.out.println();
    }

    @Test
    public void timeBetween() {
        String endTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parse = LocalDateTime.parse(endTime, formatter);
        LocalDateTime now = LocalDateTime.now();
        Duration between = Duration.between(now, parse);
        if (between.toDays() >= 0 && between.toDays() <= 5) {
            System.out.println("大兄弟，会员快过期了。。快续费");
        } else {
            System.out.println("大兄弟，状态良好");
        }
        System.out.println(between.toMillis() + " mills");
        System.out.println(between.toDays() + " days");
        System.out.println(between.toHours() + " hours");
        System.out.println(between.toMinutes() + " minutes");
    }
}
