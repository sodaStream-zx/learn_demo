package pri.zxx.learndemo.threademo.javabase.classload.classloader;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-17-23:40
 */
public class InitHello {
    static {
        System.out.println("initHello:init static");
    }

    public void show() {
        System.out.println(InitHello.class.getName() + "：hello init ");
    }
}
