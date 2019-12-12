package pri.zxx.learndemo.threads.providerAndConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 一杯咖啡
 * @desc 任务缓存管道
 * @createTime
 */
//@Component
public class FetchQueue<T> {
    private static final Logger LOG = LoggerFactory.getLogger(FetchQueue.class);
    public final List<T> queue = Collections.synchronizedList(new LinkedList<T>());
    public AtomicInteger totalSize = new AtomicInteger(0);

    public void clearQueue() {
        queue.clear();
    }

    public int getSize() {
        return queue.size();
    }

    /**
     * desc:添加任务到queue中
     *
     * @Return: void
     **/
    public synchronized void addResponseData(T rp) {
        if (rp == null) {
            return;
        }
        queue.add(rp);
        totalSize.incrementAndGet();
    }

    /**
     * desc:从queue中提取任务
     **/
    public synchronized T getResponseData() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    /**
     * desc:打印queue中的任务
     **/
    public synchronized void dump() {
        for (int i = 0; i < queue.size(); i++) {
            T it = queue.get(i);
            LOG.info("  " + i + ". " + it);
        }
    }
}
