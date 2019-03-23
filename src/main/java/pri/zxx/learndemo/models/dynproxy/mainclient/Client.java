package pri.zxx.learndemo.models.dynproxy.mainclient;


import pri.zxx.learndemo.models.dynproxy.imp.Tank;
import pri.zxx.learndemo.models.dynproxy.interfaces.Moveable;
import pri.zxx.learndemo.models.dynproxy.proxy.ByComponet;
import pri.zxx.learndemo.models.dynproxy.proxy.ByExtends;

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
