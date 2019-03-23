package pri.zxx.learndemo.threademo.threadOps.sevensigleton;

/**
 * @author 一杯咖啡
 * @desc Holder 方式实现
 * @createTime 2018-11-19-23:47
 */
public final class SixSingleton {
    private byte[] data = new byte[1024];

    private SixSingleton() {
        System.out.println("singleton is now inital");
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

    private static class Holder {
        private static SixSingleton singleton = new SixSingleton();
    }
}
