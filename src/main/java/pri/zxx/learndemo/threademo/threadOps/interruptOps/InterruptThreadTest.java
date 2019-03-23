package pri.zxx.learndemo.threademo.threadOps.interruptOps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 一杯咖啡
 * @desc 线程中断测试   线程有一个中断的标识，当调用线程的interrupt() 会将标识符改为true，
 * 标识线程被中断，但是不影响线程继续执行。调用isInterrupted() 将得到当前的线程中断标识符，并将标识符改为false
 * 调用 interrupted() 将得到当前线程的中断标识符，但不改动标识符的值。
 * @createTime 2018-11-27-22:51
 */
public class InterruptThreadTest {
    private static volatile boolean running = true;

    public static void pause(int second, int mills) {
        try {
            TimeUnit.SECONDS.sleep(second);
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread myt = new Thread(() -> {
            AtomicInteger i = new AtomicInteger(0);
            while (true) {
                pause(3, 0);
                if (!Thread.interrupted()) {
                    System.out.println("has interrupted");
                }
               /* if (Thread.currentThread().isInterrupted()) {
                    System.out.println("has interrupted");
                }*/
                // System.out.println("intrrupted?? "+Thread.currentThread().isInterrupted());
                System.out.println("test string " + i.incrementAndGet());
            }
        }, "RunningThread");
        myt.start();

        Thread monitor = new Thread(() -> {
            while (true) {
                pause(1, 0);
                //interrupt 调用该方法会将interrupted 标识 改为 true
                myt.interrupt();
                //isInterrupted 调用改方法会擦除 interrupted标识 变为 false
                // System.out.println("test---" + myt.isInterrupted());
                //InterruptThreadTest.running = false;

            }
        }, "interruptorThread");
        //monitor.setDaemon(true);
        monitor.start();
    }
}
