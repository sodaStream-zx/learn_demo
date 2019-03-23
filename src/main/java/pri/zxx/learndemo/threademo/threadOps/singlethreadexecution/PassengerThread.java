package pri.zxx.learndemo.threademo.threadOps.singlethreadexecution;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-21-17:23
 */
public class PassengerThread extends Thread {
    private String pname;
    private PassPort passPort;
    private String myPassCard;
    private String myIdenty;

    public PassengerThread(String pname, PassPort passPort, String myPassCard, String myIdenty) {
        this.passPort = passPort;
        this.pname = pname;
        this.myPassCard = myPassCard;
        this.myIdenty = myIdenty;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            passPort.pass(this);
        }
    }

    @Override
    public String toString() {
        return "PassengerThread{" +
                "pname='" + pname + '\'' +
                ", " + passPort.toString() +
                ", myPassCard='" + myPassCard + '\'' +
                ", myIdenty='" + myIdenty + '\'' +
                '}';
    }

    public String getMyPassCard() {
        return myPassCard;
    }

    public String getMyIdenty() {
        return myIdenty;
    }

    public String getPname() {
        return pname;
    }

    public PassPort getPassPort() {
        return passPort;
    }
}
