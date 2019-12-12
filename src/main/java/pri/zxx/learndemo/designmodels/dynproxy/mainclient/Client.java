package pri.zxx.learndemo.designmodels.dynproxy.mainclient;


import pri.zxx.learndemo.designmodels.dynproxy.imp.Tank;
import pri.zxx.learndemo.designmodels.dynproxy.interfaces.Moveable;
import pri.zxx.learndemo.designmodels.dynproxy.proxy.ByComponent;
import pri.zxx.learndemo.designmodels.dynproxy.proxy.ByExtends;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-07-23:04
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Moveable tank = new Tank();

        Moveable tank2 = new ByExtends();
        tank2.move();

        ByComponent tank3 = new ByComponent();
        tank3.setTank(tank);
        tank3.move();
    }
}
