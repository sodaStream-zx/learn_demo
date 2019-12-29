package pri.zxx.learndemo.quartzdemo.demo1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-27-下午 3:54
 */
public class QuartzTestDemo {
    public static void main(String[] args) throws InterruptedException, SchedulerException {
        new QuartzTestDemo().quartzNew();

    }

    public void quartzNew() throws SchedulerException, InterruptedException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        JobDetail build = JobBuilder.newJob(Dumb.class).storeDurably().build();
        Trigger trigger = TriggerBuilder.newTrigger().startNow().forJob(build).build();

        scheduler.scheduleJob(build, trigger);
        scheduler.start();
        TimeUnit.SECONDS.sleep(10);
        scheduler.shutdown();
    }
}
