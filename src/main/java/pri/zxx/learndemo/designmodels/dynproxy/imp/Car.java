package pri.zxx.learndemo.designmodels.dynproxy.imp;

import pri.zxx.learndemo.designmodels.dynproxy.interfaces.Moveable;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-12-下午 3:00
 */
public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("我是小车我怕谁？ 时速200km/h ......");
    }

    @Override
    public void stop() {
        System.out.println("我是小车，我撞上了大货车，时速0km/h ......");
    }
}
