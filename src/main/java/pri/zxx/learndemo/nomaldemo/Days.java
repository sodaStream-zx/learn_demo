package pri.zxx.learndemo.nomaldemo;

import org.junit.Test;

import java.time.LocalDate;

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
}
