package pri.zxx.learndemo.threademo.threadOps.singlethreadexecution;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-21-17:16
 */
public class PassPort {
    private int count = 0;
    private String portName = "登记口-1";

    //  private PassengerThread passengerThread;
    public synchronized void pass(PassengerThread passengerThread) {
        count++;
        check(passengerThread);
    }

    public void check(PassengerThread passengerThread) {
        if (passengerThread.getMyPassCard().charAt(0) != passengerThread.getMyIdenty().charAt(0)) {
            System.out.println(passengerThread.toString());
            System.out.println("《《--unPassed");
            System.out.println("-------------------------------------");
        } else {
            System.out.println(passengerThread.toString());
            System.out.println("--》》Passed");
            System.out.println("-------------------------------------");
        }
    }


    @Override
    public String toString() {
        return "PassPort{" +
                "count=" + count +
                ", portName='" + portName + '\'' +
                '}';
    }
}
