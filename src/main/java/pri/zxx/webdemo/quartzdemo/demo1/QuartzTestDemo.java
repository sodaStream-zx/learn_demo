package pri.zxx.webdemo.quartzdemo.demo1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-27-下午 3:54
 */
@RestController
public class QuartzTestDemo {


    @GetMapping(value = "/test")
    public void quartzNew() throws SchedulerException, InterruptedException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        JobDetail build = JobBuilder.newJob(JobFactoryImp.class)
                .storeDurably()
                .withIdentity("hello", "say")
                .usingJobData("url", "https://www.baidu.com")
                .build();
        JobDetail build2 = JobBuilder.newJob(JobFactoryImp.class)
                .storeDurably()
                .usingJobData("url", "https://blog.csdn.net/xlgdst/article/details/79104273")
                .withIdentity("hello2", "say")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger().startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(2))
                .build();
        Trigger trigger2 = TriggerBuilder.newTrigger().startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .withRepeatCount(2))
                .build();

        TriggerKey key = trigger.getKey();
        scheduler.scheduleJob(build, trigger);
        scheduler.scheduleJob(build2, trigger2);
        scheduler.start();
        TimeUnit.SECONDS.sleep(10);
        scheduler.unscheduleJob(key);
//        scheduler.shutdown();
    }
}
