package pri.zxx.learndemo.javabase.classload.classLoadSort;

/**
 * @author: 一杯咖啡
 * @desc: 子类实例化加载过程 父类
 * @createTime: 2018-11-16-0:13
 */
public class ClassLoadSort {
    static {
        System.out.println("parent static");
    }

    public ClassLoadSort() {
        System.out.println("init parent");
    }
}
