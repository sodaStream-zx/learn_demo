package pri.zxx.learndemo.threademo.threadOps.readwritelock;

import threadOps.readwritelock.ILock.Lock;
import threadOps.readwritelock.ILock.ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-23-0:12
 */
public class ShareData {
    private final List<Character> container = new ArrayList<>();
    //首先从工厂创建读、写锁
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final int length;

    public ShareData(int length) {
        this.length = length;
        for (int i = 0; i < length; i++) {
            container.add(i, 'c');
        }
    }

    /**
     * desc:读取操作
     *
     * @Return:
     **/
    public char[] read() {
        try {
            readLock.lock();
            char[] newBuffer = new char[length];
            for (int i = 0; i < length; i++) {
                newBuffer[i] = container.get(i);
            }
            System.out.println("readingNum : " + readWriteLock.getReadingReaders());
            slowly();
            return newBuffer;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {

            readLock.unlock();
        }
    }

    /**
     * desc: 写入操作
     *
     * @Return:
     **/
    public void write(char c) {
        try {
            writeLock.lock();
            for (int i = 0; i < length; i++) {
                this.container.add(i, c);
            }
            System.out.println("writingNum : " + readWriteLock.getWritingWriters());
            System.out.println("waitingNum : " + readWriteLock.getWaitingWriters());
            slowly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            writeLock.unlock();
        }
    }

    /**
     * desc: 模拟处理时间
     *
     * @Return: void
     **/
    private void slowly() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
