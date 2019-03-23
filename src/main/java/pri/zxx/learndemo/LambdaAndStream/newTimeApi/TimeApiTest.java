package pri.zxx.learndemo.LambdaAndStream.newTimeApi;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-20-21:34
 */
public class TimeApiTest {
    private static final Logger log = Logger.getLogger(TimeApiTest.class);

    /**
     * desc:LocalDate LocalTime LocalDateTime
     **/
    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime);
        LocalDateTime time2 = LocalDateTime.of(2015, 10, 19, 22, 10, 20);
        log.info(time2);
        LocalDateTime plusYears = localDateTime.plusYears(1);
        log.info(plusYears);
        log.info(localDateTime.getDayOfWeek());

    }

    /**
     * desc:instant:时间戳（1️以unix 元年，1970年1月1日00.00.00到某个时间之间的毫秒值）
     **/
    @Test
    public void instantDemo() throws InterruptedException {
        //utc 时区
        Instant isntanttime = Instant.now();
        log.info(isntanttime);
        OffsetDateTime oft = Instant.now().atOffset(ZoneOffset.ofHours(3));
        log.info(oft);
        log.info(isntanttime.toEpochMilli());
        log.info(Instant.ofEpochSecond(6));
        log.info("----------------------------");
        Instant start1 = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant end = Instant.now();
        Duration du = Duration.between(start1, end);
        log.info(du.toMillis());
        LocalDate st = LocalDate.now();
        LocalDate en = LocalDate.of(2016, 10, 21);
        log.info(Period.between(st, en));
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyyMMdd");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Callable<LocalDate> callable = () -> LocalDate.parse("20190131", dft);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(callable));
        }

        for (Future<LocalDate> x : results) {
            log.info(x.get());
        }
        pool.shutdown();
    }
}
