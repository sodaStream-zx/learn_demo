package pri.zxx.learndemo.providerandconsumer.utils;

/**
 * @author 一杯咖啡
 * @desc 解析器启动接口
 * @createTime 2018-12-21-15:51
 */
public interface IParesProcess<T> {
    /**
     * desc:解析传入的数据
     *
     * @param responseData
     **/
    void parseRun(T responseData);
}
