package pri.zxx.learndemo.designmodels.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 双加锁 可能出现空指针异常
 * @createTime 2018-11-19-23:43
 */
public final class FiveSingleton {
    private volatile static FiveSingleton singleton = null;
    private byte[] data = new byte[1204];

    private FiveSingleton() {
        System.out.println("singleton is inital now ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static FiveSingleton getInstance() {
        if (null == singleton) {
            synchronized (FiveSingleton.class) {
                if (null == singleton) {
                    singleton = new FiveSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            FiveSingleton instance = FiveSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            FiveSingleton instance = FiveSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            FiveSingleton instance = FiveSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
