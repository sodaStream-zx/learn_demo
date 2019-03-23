package pri.zxx.learndemo.threademo.threadOps.jointhread;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JoinThread {

    /**
     * desc: 创建线程，循环输出1到10
     **/
    public static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                sleep(1);
            }
        }, String.valueOf(seq));
    }

    /**
     * desc: 休眠
     **/
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(1, 3).mapToObj(JoinThread::create).collect(Collectors.toList());
        threads.forEach(Thread::start);
        //join 阻塞主线程，让新建立的2个线程先输出。
        for (Thread thread : threads) {
            thread.join();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            sleep(1);
        }
    }
}
