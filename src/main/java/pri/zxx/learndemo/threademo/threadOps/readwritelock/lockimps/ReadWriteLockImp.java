package pri.zxx.learndemo.threademo.threadOps.readwritelock.lockimps;


import pri.zxx.learndemo.threademo.threadOps.readwritelock.ILock.Lock;
import pri.zxx.learndemo.threademo.threadOps.readwritelock.ILock.ReadWriteLock;

/**
 * @author 一杯咖啡
 * @desc 锁工厂实现
 * @createTime 2018-11-22-23:44
 */
public class ReadWriteLockImp implements ReadWriteLock {
    //对象锁
    private final Object MUTEX = new Object();
    //read 和 write 的偏好
    private Boolean preferWrite = true;

    private int writingWriters = 0;
    private int waitingWriters = 0;
    private int readingWriters = 0;


    public ReadWriteLockImp() {
    }

    public ReadWriteLockImp(Boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    @Override
    public Lock readLock() {
        return new WriteLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingWriters;
    }

    public void increWritingWriters() {
        this.waitingWriters++;
    }

    public void increWaitingWriters() {
        this.waitingWriters++;
    }

    public void increReadingWriters() {
        this.waitingWriters++;
    }

    public void decreWritingWriters() {
        this.waitingWriters--;
    }

    public void decreWaitingWriters() {
        this.waitingWriters--;
    }

    public void decreReadingWriters() {
        this.waitingWriters--;
    }

    public Object getMUTEX() {
        return this.MUTEX;
    }

    public Boolean getPreferWrite() {
        return this.preferWrite;
    }

    public void setPreferWrite(Boolean preferWrite) {
        this.preferWrite = preferWrite;
    }
}
