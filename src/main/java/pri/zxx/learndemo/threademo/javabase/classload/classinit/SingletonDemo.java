package pri.zxx.learndemo.threademo.javabase.classload.classinit;

/**
 * @author: 一杯咖啡
 * @desc: 类初始化赋值过程
 * @createTime: 2018-11-14-23:48
 */
public class SingletonDemo {
    /**
     * 初始化时 sigleton 首先被初始化为null，调用构造方法后x,y为1，再初始化 x,y，并将x的值改为0
     */
    public static int y;
    public static int x = 0;
    private static SingletonDemo instance = new SingletonDemo();

    private SingletonDemo() {
        x++;
        y++;
    }

    public static SingletonDemo getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        System.out.println(x);
        System.out.println(y);
    }
}
