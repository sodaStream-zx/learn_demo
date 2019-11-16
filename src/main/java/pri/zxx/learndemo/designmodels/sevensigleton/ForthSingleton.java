package pri.zxx.learndemo.designmodels.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc double-check 双检锁，性能，线程安全同时保证，
 * @createTime 2018-11-19-23:39
 */
public final class ForthSingleton {
    //其他实例化对象引用
    private static ForthSingleton singleton = null;
    private byte[] data = new byte[1204];

    private ForthSingleton() {
        System.out.println("singleton is inital now ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ForthSingleton getInstance() {
        if (null == singleton) {
            synchronized (ForthSingleton.class) {
                if (null == singleton) {
                    singleton = new ForthSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            ForthSingleton instance = ForthSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            ForthSingleton instance = ForthSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            ForthSingleton instance = ForthSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
