package pri.zxx.webdemo.quartzdemo.demo1;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-27-下午 4:01
 */
public class Dumb implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("hello quartz");
    }
}
