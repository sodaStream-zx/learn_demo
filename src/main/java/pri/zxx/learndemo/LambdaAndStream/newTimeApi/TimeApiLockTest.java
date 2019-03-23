package pri.zxx.learndemo.LambdaAndStream.newTimeApi;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-20-21:34
 */
public class TimeApiLockTest {
    private static final Logger log = Logger.getLogger(TimeApiLockTest.class);
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}
