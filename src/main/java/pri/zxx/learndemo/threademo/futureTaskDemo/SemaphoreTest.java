package pri.zxx.learndemo.threademo.futureTaskDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc 信号量并发
 * @createTime 2019-05-10-上午 9:40
 */
public class SemaphoreTest {
    Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                semaphoreTest.test();
            }, "thread-" + i + "-").start();
        }
        TimeUnit.SECONDS.sleep(15);
    }

    public void test() {
        int availablePermits = semaphore.availablePermits();//可用资源数
//        if (availablePermits > 0) {
//            System.out.println(Thread.currentThread().getName() + "获取资源");
//        } else {
//            System.out.println(Thread.currentThread().getName() + "资源已被占用，稍后再试");
//        }
        try {
            semaphore.acquire();  //请求占用一个资源
            System.out.println("1.资源正在被" + Thread.currentThread().getName() + "使用");
            Thread.sleep(2000);//放大资源占用时间，便于观察
            System.out.println("2." + Thread.currentThread().getName() + "释放资源");
            semaphore.release();//释放一个资源
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
