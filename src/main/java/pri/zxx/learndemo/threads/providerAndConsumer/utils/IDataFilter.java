package pri.zxx.learndemo.threads.providerAndConsumer.utils;

/**
 * @author 一杯咖啡
 * @desc 数据过滤工具
 * @createTime 2018-12-26-14:47
 */
public interface IDataFilter<T> {
    boolean pass(T data);
}
