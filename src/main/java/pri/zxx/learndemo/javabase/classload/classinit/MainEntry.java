package pri.zxx.learndemo.javabase.classload.classinit;

/**
 * @author: 一杯咖啡
 * @desc:
 * @createTime: 2018-11-14-23:30
 */
public class MainEntry {
    public static void main(String[] args) throws ClassNotFoundException {
        //反射加载类
        Class.forName("javabase.classload.classinit.ChildClassInitDemo");
        // 访问静态变类初始化
        System.out.println("change 值 ：" + ChildClassInitDemo.change);
        System.out.println("Max值：" + ClassInitDemo.MAX);
        System.out.println("随机值 random ：" + ClassInitDemo.RANDOM);

        //访问静态方法，类初始化
        ChildClassInitDemo.showStatic();
        // 访问静态常量，类不初始化00
        System.out.println("CHILD 值 ：" + ChildClassInitDemo.CHILD);

    }
}
