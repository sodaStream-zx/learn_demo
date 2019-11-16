package pri.zxx.learndemo.designmodels.dynproxy.proxy;

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
        Moveable mytank = new Tank();

        //被代理类方法调用
        InvocationHandler handler = new MyInvocationHandler<>(mytank);
        //生成代理类
        Class<?> moveAble = Proxy.getProxyClass(Moveable.class.getClassLoader(), Moveable.class);
        Constructor<?> constructor = moveAble.getConstructor(InvocationHandler.class);
        Moveable o1 = (Moveable) constructor.newInstance(handler);

//        Tank o = (Tank) moveAble.newInstance();
        o1.move();
        o1.stop();
        /*Moveable tankPro = (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class[]{Moveable.class}, handler);
        tankPro.move();
        tankPro.stop();*/
    }
}
