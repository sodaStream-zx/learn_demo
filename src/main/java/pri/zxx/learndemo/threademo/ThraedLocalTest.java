package pri.zxx.learndemo.threademo;

/**
 * @author Twilight
 * @desc threadLocal 原理及应用场景
 * @createTime 2020-05-05-17:46
 */
public class ThraedLocalTest {
    public static void main(String[] args) {
        A a = new A();
        a.setInfo("这是测试数据");
        B.print(a); //此时需要明确给出一个引用类型
    }
}

class A {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class B {
    public static void print(A a) {
        System.out.println(a.getInfo());
    }
}
