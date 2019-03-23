package pri.zxx.learndemo.threademo.threadOps.readwritelock.ILock;


import pri.zxx.learndemo.threademo.threadOps.readwritelock.lockimps.ReadWriteLockImp;

/**
 * @author 一杯咖啡
 * @desc 读写锁工厂接口
 * @createTime 2018-11-22-23:37
 */
public interface ReadWriteLock {
    //获取读写锁实例
    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImp();
    }

    //获取读写锁实例，带preferWriter
    static ReadWriteLock readWriteLock(Boolean preferWriter) {
        return new ReadWriteLockImp(preferWriter);
    }

    //获取读锁
    Lock readLock();

    //获取写入锁
    Lock writeLock();

    //获取当前正在写入的线程数，最大为1
    int getWritingWriters();

    //获取当前等待获取写入锁的线程数
    int getWaitingWriters();

    //获取道歉正在读的线程数
    int getReadingReaders();
}
