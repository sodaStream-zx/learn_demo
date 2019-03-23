package pri.zxx.learndemo.models.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 饿汉单例模式, 该方式适合实例占用资源不多的情况。。线程安全，类初始化便实例化单例存于共享区
 * @createTime 2018-11-19-23:20
 */
public final class FirstSingleton {
    //初始化时实例化类
    private static FirstSingleton firstSingleton = new FirstSingleton();
    private byte[] data = new byte[1024];

    private FirstSingleton() {
        System.out.println("singleton is inital now ");
        try {
            //模拟初始化延迟时间
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static FirstSingleton getInstance() {
        return firstSingleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            FirstSingleton instance = FirstSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            FirstSingleton instance = FirstSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            FirstSingleton instance = FirstSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
