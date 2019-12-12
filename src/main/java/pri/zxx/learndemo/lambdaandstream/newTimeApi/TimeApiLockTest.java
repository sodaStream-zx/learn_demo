package pri.zxx.learndemo.lambdaandstream.newTimeApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-20-21:34
 */
public class TimeApiLockTest {
    private static final Logger log = Logger.getLogger(TimeApiLockTest.class.getName());
    //    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));
    private static DateFormat df = new SimpleDateFormat("yyyyMMdd");

    public static Date convert(String source) throws ParseException {
        return df.parse(source);
    }

    public static void main(String[] args) {
        IntStream.range(0, 2).forEach(value -> new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
            String time = "20190612";
            try {
                System.out.println(df.parse(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            }
        }, "thread-" + value).start());
    }
}
