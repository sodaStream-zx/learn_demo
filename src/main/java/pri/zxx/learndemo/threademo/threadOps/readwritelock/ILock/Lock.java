package pri.zxx.learndemo.threademo.threadOps.readwritelock.ILock;

/**
 * @author 一杯咖啡
 * @desc 锁接口
 * @createTime 2018-11-22-23:28
 */
public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
