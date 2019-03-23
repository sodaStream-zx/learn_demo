package pri.zxx.learndemo.threademo.threadOps.sevensigleton;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-19-23:43
 */
public final class FiveSingleton {
    private static FiveSingleton singleton = null;
    private byte[] data = new byte[1204];

    private FiveSingleton() {
        System.out.println("singleton is inital now ");
    }

    public static FiveSingleton getInstance() {
        if (null == singleton) {
            synchronized (FiveSingleton.class) {
                singleton = new FiveSingleton();
            }
        }
        return singleton;
    }
}
