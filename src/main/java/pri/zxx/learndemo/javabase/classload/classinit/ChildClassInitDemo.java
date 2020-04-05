package pri.zxx.learndemo.javabase.classload.classinit;

/**
 * @author: 一杯咖啡
 * @desc:
 * @createTime: 2018-11-14-23:34
 */
public class ChildClassInitDemo extends ClassInitDemo {
    public static final int CHILD = 10;
    public static int change = 20;

    static {
        System.out.println("child init ");
    }

    public static void showStatic() {
        System.out.println("static method child init");
    }

    public void show() {
        System.out.println("not static method child init");
    }
}
