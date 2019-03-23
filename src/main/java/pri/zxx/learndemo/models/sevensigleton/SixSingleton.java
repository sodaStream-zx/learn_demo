package pri.zxx.learndemo.models.sevensigleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 静态内部类 Holder 方式实现 ，在第一调用内部类时，初始化单例。保证类加载顺序
 * @createTime 2018-11-19-23:47
 */
public final class SixSingleton {
    private byte[] data = new byte[1024];

    private SixSingleton() {
        System.out.println("singleton is now inital");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SixSingleton getInstance() {
        return Holder.singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SixSingleton instance = SixSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            SixSingleton instance = SixSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            SixSingleton instance = SixSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }

    //静态内部类
    private static class Holder {
        private static SixSingleton singleton = new SixSingleton();
    }
}
