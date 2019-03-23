package pri.zxx.learndemo.threademo.threadOps.singlethreadexecution;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-21-17:27
 */
public class PassPortTest {
    public static void main(String[] args) {
        PassPort passPort = new PassPort();
        for (int i = 0; i < 2; i++) {
            new PassengerThread("正常乘客", passPort, "Azzzz" + i, "Ayyyy" + i).start();
            new PassengerThread("问题乘客", passPort, "B123", "A123").start();
        }
    }
}
