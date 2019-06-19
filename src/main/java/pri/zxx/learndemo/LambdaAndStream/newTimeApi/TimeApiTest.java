package pri.zxx.learndemo.LambdaAndStream.newTimeApi;

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
        log.info(String.valueOf(localDateTime));
        LocalDateTime time2 = LocalDateTime.of(2015, 10, 19, 22, 10, 20);
        log.info(String.valueOf(time2));
        LocalDateTime plusYears = localDateTime.plusYears(1);
        log.info(String.valueOf(plusYears));
        log.info(String.valueOf(localDateTime.getDayOfWeek()));

    }

    /**
     * desc:instant:时间戳（1️以unix 元年，1970年1月1日00.00.00到某个时间之间的毫秒值）
     **/
    @Test
    public void instantDemo() throws InterruptedException {
        //utc 时区
        Instant isntanttime = Instant.now();
        log.info(String.valueOf(isntanttime));
        OffsetDateTime oft = Instant.now().atOffset(ZoneOffset.ofHours(3));
        log.info(String.valueOf(oft));
        log.info(String.valueOf(isntanttime.toEpochMilli()));
        log.info(String.valueOf(Instant.ofEpochSecond(6)));
        log.info("----------------------------");
        Instant start1 = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant end = Instant.now();
        Duration du = Duration.between(start1, end);
        log.info(String.valueOf(du.toMillis()));
        LocalDate st = LocalDate.now();
        LocalDate en = LocalDate.of(2016, 10, 21);
        log.info(String.valueOf(Period.between(st, en)));
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
                log.info(String.valueOf(x.get(1, TimeUnit.SECONDS)));
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}
