package pri.zxx.learndemo.javabase.classload.volatiledemo;

/**
 * @author 一杯咖啡
 * @desc i++ 操作时非原子性操作。两个原子性操作，合在一起，不一定是原子性，，简单的读取和赋值操作为原子操作。
 * 读取了内存中的数据，再跟另一个变量进行了交互就不为原子性操作。
 * @createTime 2018-11-19-0:24
 */
public class Concurrency {
    static {
        int i = 0;
        int count = ++i;
        System.out.println(count);
    }

    public static void main(String[] args) {
        Concurrency concurrency = new Concurrency();
    }
}
