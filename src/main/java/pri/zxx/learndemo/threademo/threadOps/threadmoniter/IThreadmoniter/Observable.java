package pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter;

/**
 * @author 一杯咖啡
 * @desc 观察者接口
 * @createTime 2018-11-20-16:58
 */
public interface Observable {
    void startOb();

    void interruptOb();

    Cycle getCycle();

    //线程状态枚举
    enum Cycle {
        STARTED, RUNNING, DONE, ERROR, STACK
    }
}
