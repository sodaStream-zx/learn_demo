package pri.zxx.learndemo.threademo.threadOps.eventqueue;

import java.util.concurrent.TimeUnit;

public class EventClient {

    public static void pause(int second, int mills) {
        try {
            TimeUnit.SECONDS.sleep(second);
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        QueueEvent queueEvent = new QueueEvent(10);

        //创建线程，事件生产者
        new Thread(() -> {
            //int i = 0;
            // for (;;) {
            while (true) {
                //添加事件后暂停一秒
                queueEvent.offer(new QueueEvent().new Event("Num_1"));
                pause(0, 500);
            }
        }, "Producer_1").start();
        new Thread(() -> {
            //int i = 0;
            // for (;;) {
            while (true) {
                //添加事件后暂停一秒
                queueEvent.offer(new QueueEvent().new Event("Num_1"));
                pause(0, 500);
            }
        }, "Producer_2").start();

        //创建线程，事件消费者
        new Thread(() -> {
            // for(;;) {
            while (true) {
                queueEvent.take();
                //添加事件后暂停2秒
                pause(1, 0);
            }
        }, "Consumer_1").start();

        new Thread(() -> {
            //for (;;) {
            while (true) {
                queueEvent.take();
                //添加事件后暂停2秒
                pause(1, 0);
            }
        }, "Consumer_2").start();
    }
}
