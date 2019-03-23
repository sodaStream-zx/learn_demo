package pri.zxx.learndemo.threademo.threadOps.threadmoniter.threadmoniterImp;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 线程监视实现 测试
 * @createTime 2018-11-20-23:02
 */
public class ObservableThreadCaller {
    public static void main(String[] args) throws IllegalAccessException {
        for (int i = 0; i < 5; i++) {
            ObservableThreadApp observableThreadApp = new ObservableThreadApp(new MyLifecycle(), () -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    //创建异常
                    // int num = 2 / 0;
                    //System.out.println(num);
                    return " this is a result String ";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }, "TestThread" + i);
            observableThreadApp.startOb();
        }
    }
}
