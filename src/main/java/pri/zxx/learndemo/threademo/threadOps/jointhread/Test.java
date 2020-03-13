package pri.zxx.learndemo.threademo.threadOps.jointhread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author zxx
 * @desc
 * @createTime 2020-01-14-上午 10:33
 */
public class Test implements Runnable {
    private CountDownLatch countDownLatch;

    public Test(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Test test = new Test(countDownLatch);
        for (int i = 0; i < 3; i++) {
            new Thread(test).start();
        }
    }

    @Override
    public void run() {
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                notify();
                System.out.println(currentThread() + "i = " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
