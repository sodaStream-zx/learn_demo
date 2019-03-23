package pri.zxx.learndemo.threademo.threadOps.readwritelock.lockimps;

import threadOps.readwritelock.ILock.Lock;

/**
 * @author 一杯咖啡
 * @desc 写入锁
 * @createTime 2018-11-22-23:54
 */
public class WriteLock implements Lock {
    private final ReadWriteLockImp readWriteLockImp;

    public WriteLock(ReadWriteLockImp readWriteLockImp) {
        this.readWriteLockImp = readWriteLockImp;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLockImp.getMUTEX()) {
            try {
                readWriteLockImp.increWritingWriters();
                while (readWriteLockImp.getReadingReaders() > 0 || readWriteLockImp.getWritingWriters() > 0) {
                    readWriteLockImp.getMUTEX().wait();
                }
            } finally {
                this.readWriteLockImp.decreWaitingWriters();
            }
            readWriteLockImp.increWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLockImp.getMUTEX()) {
            readWriteLockImp.decreWritingWriters();
            readWriteLockImp.increWaitingWriters();
            readWriteLockImp.setPreferWrite(false);
            readWriteLockImp.getMUTEX().notifyAll();
        }
    }
}
