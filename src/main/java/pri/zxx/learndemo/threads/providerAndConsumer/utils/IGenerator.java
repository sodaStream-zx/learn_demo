package pri.zxx.learndemo.threads.providerAndConsumer.utils;

/**
 * @author 一杯咖啡
 * @desc 数据提取工具
 * @createTime 2018-12-26-14:46
 */
public interface IGenerator<T> {
    T getData();
}
