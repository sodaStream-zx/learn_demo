package pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-20-17:03
 */
public interface TaskLifecycle<T> {
    //任务启动时触发onstart方法
    void onStart(Thread thread);

    //任务运行时触发onsRunning方法
    void onRunning(Thread thread);

    //任务结束时触发onFinish方法
    void onFinish(Thread thread, T result);

    //任务出错时触发onError方法
    void onError(Thread thread, Exception e);

    //任务阻塞时触发onStack方法
    void onStack(Thread thread);

    //空实现
    class EmptyLifecycle<T> implements TaskLifecycle<T> {

        @Override
        public void onStart(Thread thread) {
            //do nothing
        }

        @Override
        public void onRunning(Thread thread) {
            //do nothing
        }

        @Override
        public void onFinish(Thread thread, T result) {
            //do nothing
        }

        @Override
        public void onError(Thread thread, Exception e) {
            //do nothing
        }

        @Override
        public void onStack(Thread thread) {
            //do nothing
        }
    }
}
