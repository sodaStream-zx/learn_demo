package pri.zxx.webdemo.quartzdemo.demo1;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.util.StringUtils;
import pri.zxx.webdemo.quartzdemo.utils.JobExecutorUtil;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-30-下午 2:13
 */
public class JobFactoryImp implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        Object url = mergedJobDataMap.get("url");
        if (!StringUtils.isEmpty(url)) {
            JobExecutorUtil.invokeJob(url.toString());
        } else {
            System.out.println("url为空");
        }
    }
}
