package pri.zxx.learndemo.threademo.futureTaskDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc 信号量并发
 * @createTime 2019-05-10-上午 9:40
 */
public class TestSem {
    Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        TestSem testSem = new TestSem();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(testSem.test());
            });
        }
        TimeUnit.SECONDS.sleep(15);
    }

    public String test() {
        int availablePermits = semaphore.availablePermits();//可用资源数
        if (availablePermits > 0) {
            System.out.println("抢到资源");
        } else {
            System.out.println("资源已被占用，稍后再试");
            return "Resource is busy！";
        }
        try {
            semaphore.acquire(1);  //请求占用一个资源
            System.out.println("资源正在被使用");
            Thread.sleep(2000);//放大资源占用时间，便于观察
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(1);//释放一个资源
        }
        return "Success";
    }
}
