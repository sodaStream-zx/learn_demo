package pri.zxx.learndemo.threademo.threadOps.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static io.netty.util.internal.ThreadLocalRandom.current;
import static java.lang.Thread.currentThread;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-22-20:18
 */
public class BooleanLockClient {
    private final BooleanLock booleanLock = new BooleanLock();

    public static void main(String[] args) {
        BooleanLockClient client = new BooleanLockClient();
        IntStream.range(0, 10).mapToObj(value -> new Thread(client::syncMethod)).forEach(Thread::start);

    }

    public void syncMethod() {
        try {
            booleanLock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + "get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            booleanLock.unlock();
        }
    }
}
