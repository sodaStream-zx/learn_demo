package pri.zxx.webdemo.msg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc 状态机
 * @createTime 2019-08-08-下午 2:19
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class MsgOpsTest {
    @Autowired
    private MsgOps msgOps;

    @Test
    public void myTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        String[] As = new String[]{
                "5-0-123456789-A", "6-0-123456789-A",
                "1-0-123456789-A", "2-0-123456789-A",
                "2-0-123456789-A", "3-0-123456789-A",
                "3-0-123456789-A", "4-0-123456789-A",
                "9-0-123456789-A", "8-0-123456789-A",
                "6-0-123456789-A", "7-0-123456789-A",
                "4-0-123456789-A", "5-0-123456789-A",
                "8-0-123456789-A", "9-0-123456789-A"
        };
        String[] Bs = new String[]{
                "1-0-123456789-B", "2-0-123456789-B",
                "7-0-123456789-B", "8-0-123456789-B",
                "3-0-123456789-B", "4-0-123456789-B",
                "2-0-123456789-B", "3-0-123456789-B",
                "5-0-123456789-B", "6-0-123456789-B",
                "4-0-123456789-B", "5-0-123456789-B",
                "9-0-123456789-B", "1-0-123456789-B",
                "6-0-123456789-B", "7-0-123456789-B",
                "8-0-123456789-B", "9-0-123456789-B"
        };
        String[] Bs2 = new String[]{
                "5-0-123456789-C", "6-0-123456789-C",
                "3-0-123456789-C", "4-0-123456789-C",
                "7-0-123456789-C", "8-0-123456789-C",
                "8-0-123456789-C", "9-0-123456789-C",
                "2-0-123456789-C", "3-0-123456789-C",
                "4-0-123456789-C", "5-0-123456789-C",
                "6-0-123456789-C", "7-0-123456789-C",
                "1-0-123456789-C", "2-0-123456789-C",
                "9-0-123456789-C", "1-0-123456789-C"
        };
        String[] Bs3 = new String[]{
                "7-0-123456789-D", "8-0-123456789-D",
                "6-0-123456789-D", "7-0-123456789-D",
                "5-0-123456789-D", "6-0-123456789-D",
                "1-0-123456789-D", "2-0-123456789-D",
                "9-0-123456789-D", "1-0-123456789-D",
                "2-0-123456789-D", "3-0-123456789-D",
                "4-0-123456789-D", "5-0-123456789-D",
                "3-0-123456789-D", "4-0-123456789-D",
                "8-0-123456789-D", "9-0-123456789-D"
        };

        String[] coms = new String[]{
                "{\"imie\": \"1-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"3-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"2-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"4-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"5-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"7-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"8-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"9-0-123456789\", \"status\": 1}\n",
                "{\"imie\": \"6-0-123456789\", \"status\": 1}\n"
        };

        threadPoolExecutor.execute(() -> {
            try {
                msgOps.loopCheck();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        List<String> listA = Arrays.asList(As);
        List<String> comss = Arrays.asList(coms);
        threadPoolExecutor.execute(() -> comss.stream().forEach(s -> {
            msgOps.gainMsg(s);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        threadPoolExecutor.execute(() -> listA.stream().forEach(s -> {
            msgOps.gainMsg(s);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));


        List<String> listB = Arrays.asList(Bs);
        threadPoolExecutor.execute(() -> listB.stream().forEach(s -> {
            msgOps.gainMsg(s);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        List<String> listc = Arrays.asList(Bs2);
        threadPoolExecutor.execute(() -> listc.stream().forEach(s -> {
            msgOps.gainMsg(s);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        List<String> listD = Arrays.asList(Bs3);
        threadPoolExecutor.execute(() -> listD.stream().forEach(s -> {
            msgOps.gainMsg(s);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));


//        Arrays.asList(all).stream().forEach(s -> {
//            msgOps.gainMsg(s);
//            try {
//                TimeUnit.MILLISECONDS.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        });


        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

