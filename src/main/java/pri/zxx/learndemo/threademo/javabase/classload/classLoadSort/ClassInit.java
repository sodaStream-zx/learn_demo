package pri.zxx.learndemo.threademo.javabase.classload.classLoadSort;

/**
 * @author: 一杯咖啡
 * @desc: 类初始化
 * @createTime: 2018-11-16-0:20
 */
public class ClassInit {
    public static void main(String[] args) {
        System.out.println("childValue = " + Child.childValue);
    }

    static class Parent {
        static int patentValue = 10;

        static {
            patentValue = 20;
        }
    }

    static class Child extends Parent {
        static int childValue = patentValue;
    }
}
