package pri.zxx.learndemo.javabase.classload.threadclassloader;

import static java.lang.Thread.currentThread;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-18-0:19
 */
public class ThreadClassLoader {
    public static void main(String[] args) {
        System.out.println("thread classloader：" + currentThread().getContextClassLoader());
        System.out.println("thread classloader2：" + currentThread().getClass().getClassLoader());
    }
}
