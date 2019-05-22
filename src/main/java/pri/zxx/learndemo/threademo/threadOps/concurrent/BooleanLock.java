package pri.zxx.learndemo.threademo.threadOps.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

public class BooleanLock implements Lock {
    //存储当前等待的线程
    private final List<Thread> blockedList = new ArrayList<>();
    //当前拿到锁的线程
    private Thread currentThread;
    //锁状态
    private boolean locked = false;

    @Override
    public void lock() throws InterruptedException {
        //拿锁
        synchronized (this) {
            //如果已经被锁住了
            try {
                while (locked) {
                    //添加到到等待中的线程队列
                    blockedList.add(currentThread());
                    this.wait();
                }
            } catch (InterruptedException e) {
                //中断后 移除 等待队列中的线程
                this.blockedList.remove(currentThread());
                throw e;
            }
            //未锁住 移除
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the locak after " + mills + " waiting");
                    }
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                        this.wait(remainingMills);
                        remainingMills = endMills - currentTimeMillis();
                    }
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + "release the lock.").
                        ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
