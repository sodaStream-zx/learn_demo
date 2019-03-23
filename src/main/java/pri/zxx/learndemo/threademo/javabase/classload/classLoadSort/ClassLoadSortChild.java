package pri.zxx.learndemo.threademo.javabase.classload.classLoadSort;

/**
 * @author: 一杯咖啡
 * @desc:子类实例化加载过程子类
 * @createTime: 2018-11-16-0:14
 */
public class ClassLoadSortChild extends ClassLoadSort {
    static {
        System.out.println("child static");
    }

    public ClassLoadSortChild() {
        System.out.println("init child");
    }

    public static void main(String[] args) {
        //第一次实例化，静态部分只加载一次
        ClassLoadSortChild classLoadSortChild = new ClassLoadSortChild();
        ClassLoadSortChild classLoadSortChild1 = new ClassLoadSortChild();
    }
}
