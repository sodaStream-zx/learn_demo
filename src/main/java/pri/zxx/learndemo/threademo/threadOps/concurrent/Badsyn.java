package pri.zxx.learndemo.threademo.threadOps.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-05-20-下午 1:49
 */
public class Badsyn {

    public static synchronized void synMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Badsyn badsyn = new Badsyn();
        Thread t1 = new Thread(Badsyn::synMethod, "Thread-1");
        t1.start();
        Thread t2 = new Thread(Badsyn::synMethod, "Thread-2");
    }
}
