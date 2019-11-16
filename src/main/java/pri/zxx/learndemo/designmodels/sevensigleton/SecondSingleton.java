package pri.zxx.learndemo.designmodels.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 懒汉模式，线程不安全，多线程下，会出现实例化多次的情况
 * @createTime 2018-11-19-23:23
 */
public final class SecondSingleton {
    private static SecondSingleton singleton = null;
    private byte[] data = new byte[1204];

    private SecondSingleton() {
        System.out.println("singleton is inital now ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SecondSingleton getInstance() {
        if (null == singleton) {
            singleton = new SecondSingleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SecondSingleton instance = SecondSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            SecondSingleton instance = SecondSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            SecondSingleton instance = SecondSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
