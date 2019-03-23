package pri.zxx.learndemo.threademo.threadOps.readwritelock.lockimps;


import pri.zxx.learndemo.threademo.threadOps.readwritelock.ILock.Lock;

/**
 * @author 一杯咖啡
 * @desc 读取锁
 * @createTime 2018-11-22-23:54
 */
public class ReadLock implements Lock {
    private final ReadWriteLockImp readWriteLockImp;

    public ReadLock(ReadWriteLockImp readWriteLockImp) {
        this.readWriteLockImp = readWriteLockImp;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLockImp.getMUTEX()) {
            while (readWriteLockImp.getWritingWriters() > 0 || (readWriteLockImp.getPreferWrite() && readWriteLockImp.getWaitingWriters() > 0)) {
                readWriteLockImp.getMUTEX().wait();
            }
            readWriteLockImp.decreWaitingWriters();
            readWriteLockImp.increReadingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLockImp.getMUTEX()) {
            readWriteLockImp.decreReadingWriters();
            readWriteLockImp.increWaitingWriters();
            readWriteLockImp.setPreferWrite(true);
            readWriteLockImp.getMUTEX().notifyAll();
        }
    }
}
