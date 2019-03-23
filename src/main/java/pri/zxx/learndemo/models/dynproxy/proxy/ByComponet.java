package pri.zxx.learndemo.models.dynproxy.proxy;


import pri.zxx.learndemo.models.dynproxy.interfaces.Moveable;

/**
 * @author 一杯咖啡
 * @desc 记录时间，通过聚合的方式
 * @createTime 2018-12-07-23:33
 */
public class ByComponet implements Moveable {
    private Moveable moveable;

    public void setTank(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("通过聚合实现代理");
        Long startTime = System.currentTimeMillis();
        moveable.move();
        Long endTime = System.currentTimeMillis();
        System.out.println("运行时间-->>" + (endTime - startTime) + "ms");
        System.out.println("--------------------------------");

    }

    @Override
    public void stop() {
        System.out.println("通过聚合实现代理");
        Long startTime = System.currentTimeMillis();
        moveable.stop();
        Long endTime = System.currentTimeMillis();
        System.out.println("运行时间-->>" + (endTime - startTime) + "ms");
        System.out.println("--------------------------------");
    }
}
