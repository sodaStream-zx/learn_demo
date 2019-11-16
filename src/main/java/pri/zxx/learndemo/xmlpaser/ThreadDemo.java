package pri.zxx.learndemo.xmlpaser;

public class ThreadDemo {
    final Object lock1 = new Object();
    boolean signal = false;

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        demo.demo6();
    }

    /**
     * 编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……X4950Y5152Z，
     * 要求使用线程间的通信
     */
    public void demo6() {
        new Thread(() -> {
            synchronized (lock1) {
                for (int i = 1; i <= 52; i = i + 2) {
                    while (signal) {
                        try {
                            lock1.wait();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    System.out.print(i + 1 + " ");
                    signal = true;
                    lock1.notify();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock1) {
                for (char j = 'A'; j <= 'Z'; j++) {
                    while (!signal) {
                        try {
                            lock1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(j + " ");
                    signal = false;
                    lock1.notify();
                }

            }
        }).start();
    }
}