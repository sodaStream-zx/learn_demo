package pri.zxx.learndemo.threademo.threadOps.sevensigleton;

/**
 * @author 一杯咖啡
 * @desc 枚举方式
 * @createTime 2018-11-19-23:57
 */
public enum SevenSingleton {
    INSTANCE;
    private byte[] data = new byte[1014];

    SevenSingleton() {
        System.out.println("stance is now inital");
    }

    public static SevenSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SevenSingleton instance = SevenSingleton.getInstance();
            System.out.println("instance1:" + instance.toString());
        }, "t1").start();
        new Thread(() -> {
            SevenSingleton instance = SevenSingleton.getInstance();
            System.out.println("instance2:" + instance.toString());
        }, "t2").start();
        new Thread(() -> {
            SevenSingleton instance = SevenSingleton.getInstance();
            System.out.println("instance3:" + instance.toString());
        }, "t3").start();
    }
}
