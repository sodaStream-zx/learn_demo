package pri.zxx.learndemo.models.dynproxy.imp;


import pri.zxx.learndemo.models.dynproxy.interfaces.Moveable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-07-22:56
 */
public class Tank implements Moveable {
    @Override
    public void move() {

        System.out.println("Tank is moving------");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            System.out.println("休眠出错---");
        }

    }

    @Override
    public void stop() {
        System.out.println("tank is stoping------");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            System.out.println("休眠出错---");
        }
    }
}
