package pri.zxx.learndemo.threademo.futureTaskDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Twilight
 * @desc 线程同步执行测试
 * @createTime 2019-06-08-13:41
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("countDown" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread+" + i).
                    start();
        }
        System.out.println("5秒后开始执行所有线程");
        TimeUnit.SECONDS.sleep(5);
        countDownLatch.countDown();
    }
}
