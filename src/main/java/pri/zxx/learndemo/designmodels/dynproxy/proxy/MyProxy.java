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
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Moveable myTank = new Tank();

        //被代理类方法调用
        InvocationHandler handler = new MyInvocationHandler<>(myTank);
        //生成代理类
        Class<?> moveAble = Proxy.getProxyClass(Moveable.class.getClassLoader(), Moveable.class);
        Constructor<?> constructor = moveAble.getConstructor(InvocationHandler.class);
        Moveable o1 = (Moveable) constructor.newInstance(handler);

        o1.move();
        o1.stop();
        System.out.println("----------------------------------------------------------");

        Moveable tankPro = (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class[]{Moveable.class}, handler);
        tankPro.move();
        tankPro.stop();

        System.out.println("---------------------------------------------------------");
        Moveable myCar = new Car();
        Moveable o = (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class[]{Moveable.class}, new MyInvocationHandler<>(myCar));
        o.move();
        o.stop();

        System.out.println("----------------------------------------------------------");
        InvocationHandler carHandler = new MyInvocationHandler<>(myCar);
        Class<?> proxyClass = Proxy.getProxyClass(Moveable.class.getClassLoader(), Moveable.class);
        Constructor<?> constructor1 = proxyClass.getConstructor(InvocationHandler.class);
        Moveable car = (Moveable) constructor1.newInstance(carHandler);
        car.move();
        car.stop();

    }
}
