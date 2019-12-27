package pri.zxx.learndemo.quartzdemo.demo1;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-27-下午 3:54
 */
public class QuartzTestDemo {
    public void quartzNew() throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        scheduler.addJob(new JobDetailImpl(), true);
    }
}
