package pri.zxx.learndemo.designmodels.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 懒汉模式 + 同步，线程安全，同一时间只有单个线程访问，效率低下
 * @createTime 2018-11-19-23:32
 */
public final class ThirdSingleton {
    private static ThirdSingleton singleton = null;
    private byte[] data = new byte[1204];

    private ThirdSingleton() {
        System.out.println("singleton is inital now ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ThirdSingleton getInstance() {
        if (null == singleton) {
            singleton = new ThirdSingleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            ThirdSingleton instance = ThirdSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            ThirdSingleton instance = ThirdSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            ThirdSingleton instance = ThirdSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
