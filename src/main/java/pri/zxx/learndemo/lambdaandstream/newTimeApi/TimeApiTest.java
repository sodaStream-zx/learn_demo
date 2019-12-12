package pri.zxx.learndemo.lambdaandstream.newTimeApi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-20-21:34
 */
public class TimeApiTest {
    private static final Logger log = Logger.getLogger(TimeApiTest.class.getName());

    /**
     * desc:LocalDate LocalTime LocalDateTime
     **/
    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime time2 = LocalDateTime.of(2015, 10, 19, 22, 10, 20);
        System.out.println(time2);
        LocalDateTime plusYears = localDateTime.plusYears(1);
        System.out.println(plusYears);
        System.out.println(localDateTime.getDayOfWeek());

    }

    /**
     * desc:instant:时间戳（1️以unix 元年，1970年1月1日00.00.00到某个时间之间的毫秒值）
     **/
    @Test
    public void instantDemo() throws InterruptedException {
        //utc 时区
        Instant isntanttime = Instant.now();
        System.out.println(isntanttime);
        OffsetDateTime oft = Instant.now().atOffset(ZoneOffset.ofHours(3));
        System.out.println(oft);
        System.out.println(isntanttime.toEpochMilli());
        System.out.println(Instant.ofEpochSecond(6));
        System.out.println("----------------------------");
        Instant start1 = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant end = Instant.now();
        Duration du = Duration.between(start1, end);
        System.out.println(du.toMillis());
        LocalDate st = LocalDate.now();
        LocalDate en = LocalDate.of(2016, 10, 21);
        System.out.println(Period.between(st, en));
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Callable<LocalDate> callable = () -> LocalDate.parse("2019-01-31", dft);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(callable));
        }
        try {
            for (Future<LocalDate> x : results) {
                System.out.println(x.get(1, TimeUnit.SECONDS));
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}
