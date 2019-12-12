package pri.zxx.learndemo.designmodels.dynproxy.imp;

import pri.zxx.learndemo.designmodels.dynproxy.interfaces.Moveable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-12-下午 3:00
 */
public class Car implements Moveable {
    @Override
    public void move() throws InterruptedException {
        System.out.println("我是小车我怕谁？ 时速200km/h ......");
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    }

    @Override
    public void stop() {
        System.out.println("我是小车，我撞上了大货车，时速0km/h ......");
    }
}
