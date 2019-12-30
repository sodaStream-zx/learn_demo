package pri.zxx.webdemo.quartzdemo.demo1;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.util.StringUtils;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-30-下午 2:13
 */
public class JobFactoryImp implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Object url = jobDataMap.get("url");
        if (!StringUtils.isEmpty(url)) {
            JobExecutorUtil.invokeJob(url.toString());
        } else {
            System.out.println("url为空");
        }
    }
}
