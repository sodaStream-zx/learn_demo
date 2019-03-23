package pri.zxx.learndemo.threademo.threadOps.eatnoodle;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 吃面人
 * @createTime 2018-11-21-23:23
 */
public class TableEatNoodle extends Thread {
    private final IEatTool leftTool;
    private final IEatTool rightTool;
    private String customName;

    public TableEatNoodle(String customName, IEatTool leftTool, IEatTool rightTool) {
        this.customName = customName;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
            // yield();
        }
    }

    public void eat() {
        synchronized (leftTool) {
            System.out.println("----------------start-------------");
            System.out.println(this.customName + ": 拿起左手餐具-" + this.leftTool.getTool());
            synchronized (rightTool) {
                System.out.println(this.customName + " 拿起右手餐具-" + this.rightTool.getTool());
                System.out.println(this.customName + " 吃面中......");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.customName + " 放下右手餐具" + this.rightTool.getTool());
            }
            System.out.println(this.customName + " 放下左手餐具" + this.leftTool.getTool());
            System.out.println("----------------end-------------");
            System.out.println(" ");
        }
    }
}
