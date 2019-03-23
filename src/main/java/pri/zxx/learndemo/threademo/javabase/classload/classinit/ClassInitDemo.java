package pri.zxx.learndemo.threademo.javabase.classload.classinit;

/**
 * @author: 一杯咖啡
 * @desc:
 * @createTime: 2018-11-14-23:27
 */
public class ClassInitDemo {
    public final static int MAX = 100;
    public final static double RANDOM = Math.random();

    static {
        System.out.println("parent init ");
    }
}
