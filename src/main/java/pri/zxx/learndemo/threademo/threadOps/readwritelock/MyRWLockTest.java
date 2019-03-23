package pri.zxx.learndemo.threademo.threadOps.readwritelock;

import static java.lang.Thread.currentThread;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-11-23-0:06
 */
public class MyRWLockTest {
    private static final String TEXT = "Thisisasimpleteststringjusttestreadwritelock";

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < TEXT.length(); j++) {
                    char c = TEXT.charAt(j);
                    shareData.write(c);
                    System.out.println(currentThread() + " :  write " + c);
                }
            }, "writer" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(currentThread() + " :  read " + new String(shareData.read()));
                    System.out.println();
                }
            }, "reader" + i).start();
        }
    }
}
