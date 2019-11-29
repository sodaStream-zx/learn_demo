package pri.zxx.learndemo.designmodels.dynproxy.mainclient;


import pri.zxx.learndemo.designmodels.dynproxy.imp.Tank;
import pri.zxx.learndemo.designmodels.dynproxy.interfaces.Moveable;
import pri.zxx.learndemo.designmodels.dynproxy.proxy.ByComponet;
import pri.zxx.learndemo.designmodels.dynproxy.proxy.ByExtends;

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

        ByComponet tank3 = new ByComponet();
        tank3.setTank(tank);
        tank3.move();
    }
}
