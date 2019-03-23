package pri.zxx.learndemo.threademo.threadOps.concurrent;

import java.util.ArrayList;
import java.util.List;

public class BooleanLock implements Lock {
    private final List<Thread> blockedList = new ArrayList<>();
    private Thread currentThread;
    private boolean locked = false;

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                blockedList.add(Thread.currentThread());
                this.wait();
            }
            blockedList.remove(Thread.currentThread());
            this.locked = true;
            this.currentThread = currentThread;
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long endMills = +mills;
            }
        }
    }

    @Override
    public void unlock() {

    }

    @Override
    public List<Thread> getBlockedThreads() {
        return null;
    }
}
