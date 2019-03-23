package pri.zxx.learndemo.models.dynproxy.proxy;


import pri.zxx.learndemo.models.dynproxy.imp.Tank;

/**
 * @author 一杯咖啡
 * @desc 记录方法执行时间， 通过继承的方式
 * @createTime 2018-12-07-23:32
 */
public class ByExtends extends Tank {
    @Override
    public void move() {
        System.out.println("通过继承实现代理");
        Long startTime = System.currentTimeMillis();
        super.move();
        Long endTime = System.currentTimeMillis();
        System.out.println("运行时间-->>" + (endTime - startTime) + "ms");
        System.out.println("--------------------------------");
    }

    @Override
    public void stop() {
        System.out.println("通过继承实现代理");
        Long startTime = System.currentTimeMillis();
        super.stop();
        Long endTime = System.currentTimeMillis();
        System.out.println("运行时间-->>" + (endTime - startTime) + "ms");
        System.out.println("--------------------------------");
    }

}
