package pri.zxx.webdemo.quartzdemo;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-27-下午 3:45
 */
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException {
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        defaultScheduler.shutdown();
    }
}
