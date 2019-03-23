package pri.zxx.learndemo.threademo.threadOps.threadmoniter.threadmoniterImp;


import pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter.TaskLifecycle;

/**
 * @author 一杯咖啡
 * @desc 线程生命周期监测
 * @createTime 2018-11-21-11:06
 */
public class MyLifecycle implements TaskLifecycle<String> {
    @Override
    public void onStart(Thread thread) {
        System.out.println("【" + thread.getName() + "】 is on start");
    }

    @Override
    public void onRunning(Thread thread) {
        System.out.println("【" + thread.getName() + "】 is on running");
    }

    @Override
    public void onFinish(Thread thread, String result) {
        System.out.println("【" + thread.getName() + "】 is finished,and the result：" + result);
    }

    @Override
    public void onError(Thread thread, Exception e) {
        System.out.println("【" + thread.getName() + "】 has occured a exception " + e.getCause() + " : " + e.getMessage());
    }

    @Override
    public void onStack(Thread thread) {
        System.out.println("【" + thread.getName() + "】 is on stack");
    }
}
