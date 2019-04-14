package pri.zxx.learndemo.threademo.futureTaskDemo;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-04-01-下午 1:25
 */
public class FutureTaskTest {
    @Test
    public void futureTest() throws ExecutionException, InterruptedException, TimeoutException {
        //建立线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                20,
                20L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new DefaultThreadFactory("这是线程池名哦"));
        //执行任务
        Future<Integer> result = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                int i = 0;
                for (int j = 0; j < 500; j++) {
                    i += j;
                }
                return i;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 0;
            }
        });
        //获取结果
        try {
            Integer sum = result.get(2, TimeUnit.SECONDS);
            System.out.println("sum = " + sum);
        } catch (Exception e) {
            System.out.println("读取超时");
        }

        FutureTask ft = new FutureTask(() -> {
            Optional<Integer> reduce = Stream.iterate(1, s -> s + 2).limit(10).reduce(Integer::sum);
            if (reduce.isPresent()) {
                return reduce.get();
            } else {
                return 0;
            }
        });
        executor.submit(ft);
        System.out.println(ft.get());
        //futureTask
        executor.submit(ft);
        if (ft.isDone()) {
            System.out.println(ft.isDone());
            System.out.println(ft.get(1, TimeUnit.SECONDS));
        } else {
            System.out.println("任务出错");
        }
    }
}
