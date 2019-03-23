package pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter;

/**
 * @author 一杯咖啡
 * @desc 任务接口
 * @createTime 2018-11-20-17:09
 */
@FunctionalInterface
public interface Task<T> {
    //任务执行接口，返回结果
    T call();
}
