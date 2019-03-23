package pri.zxx.learndemo.models.dynproxy.mainclient;

import models.dynproxy.imp.Tank;
import models.dynproxy.interfaces.Moveable;
import models.dynproxy.proxy.ByComponet;
import models.dynproxy.proxy.ByExtends;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-07-23:04
 */
public class Client {
    public static void main(String[] args) {
        Moveable tank = new Tank();

        Moveable tank2 = new ByExtends();
        tank2.move();

        Moveable tank3 = new ByComponet();
        ((ByComponet) tank3).setTank(tank);
        tank3.move();
    }
}
