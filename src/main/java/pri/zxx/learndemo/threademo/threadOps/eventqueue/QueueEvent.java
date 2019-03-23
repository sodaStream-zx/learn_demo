package pri.zxx.learndemo.threademo.threadOps.eventqueue;

import java.util.LinkedList;

public class QueueEvent {
    private static final Integer DEFAULT_MAX_EVENT = 10;
    private final Integer MAX;
    private final LinkedList<Event> queue = new LinkedList<>();

    public QueueEvent() {
        this.MAX = DEFAULT_MAX_EVENT;
        //this(DEFAULT_MAX_EVENT);
    }

    public QueueEvent(int max) {
        this.MAX = max;
    }

    /**
     * desc:向queue中添加时间
     **/
    public void offer(Event event) {
        synchronized (queue) {
            if (queue.size() >= MAX) {
                try {
                    console("queue is full.");
                    console("-------------------");
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is in");
            queue.addLast(event);
            console("the queue size: " + queue.size());
            this.queue.notifyAll();
        }
    }

    /**
     * desc:从queue中取事件
     **/
    public Event take() {
        synchronized (queue) {
            if (queue.isEmpty()) {
                try {
                    console("this queue is empty.");
                    console("-------------------");
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = queue.removeFirst();
            this.queue.notifyAll();
            console("the event " + event.getName() + " has out");
            return event;
        }
    }

    /**
     * desc:打印信息
     **/
    public void console(String s) {
        System.out.println(Thread.currentThread().getName() + "  :  " + s);
    }

    class Event {
        private String name;

        public Event(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
