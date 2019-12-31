package pri.zxx.webdemo.quartzdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pri.zxx.webdemo.quartzdemo.model.JobData;

import java.util.List;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-31-上午 9:39
 */
@Mapper
public interface JobsMapper {
    @Select(value = "select * from t_jobs ")
    List<JobData> listAllJobs();
}
