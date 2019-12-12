package pri.zxx.learndemo.designmodels.dynproxy.proxy;

import pri.zxx.learndemo.designmodels.dynproxy.imp.Car;
import pri.zxx.learndemo.designmodels.dynproxy.imp.Tank;
import pri.zxx.learndemo.designmodels.dynproxy.interfaces.Moveable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-08-0:02
 */
public class MyProxy {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, InterruptedException, ClassNotFoundException {
        Moveable myTank = new Tank();
        Moveable myCar = new Car();
        //被代理类方法调用
        InvocationHandler handler = new MyInvocationHandler<>(myTank);
        //生成代理类
        Class<?> moveAble = Proxy.getProxyClass(Moveable.class.getClassLoader(), Moveable.class);
        Constructor<?> constructor = moveAble.getConstructor(InvocationHandler.class);
        Moveable tank = (Moveable) constructor.newInstance(handler);
        tank.move();
        tank.stop();

        System.out.println("----------------------------------------------------------");
        InvocationHandler carHandler = new MyInvocationHandler<>(myCar);
        Class<?> proxyClass = Proxy.getProxyClass(Moveable.class.getClassLoader(), Moveable.class);
        Constructor<?> constructor1 = proxyClass.getConstructor(InvocationHandler.class);
        Moveable car = (Moveable) constructor1.newInstance(carHandler);
        car.move();
        car.stop();

        System.out.println("----------------------------------------------------------");
        Moveable target = (Moveable) new MyInvocationHandler<>(myCar).createTarget();
        target.move();
        target.stop();

        System.out.println("----------------------------------------------------------");
    }
}
