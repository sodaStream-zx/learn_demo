package pri.zxx.learndemo.threademo.javabase.classload.volatiledemo;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author 一杯咖啡
 * @desc 关键词 volatile
 * @createTime 2018-11-18-16:45
 */
public class VolatileTest {
    final static Integer MAX = 10;
    static volatile Integer init_value = 0;

    public static void pause(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.println("[" + currentThread().getName() + "]init_value = " + init_value);
                    localValue = init_value;
                }
            }
        }, "reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.println("[" + currentThread().getName() + "]initValue Change : " + (++localValue));
                init_value = localValue;
                pause(1);
            }
        }, "changer").start();
    }
}
