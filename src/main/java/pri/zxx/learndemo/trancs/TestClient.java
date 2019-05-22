package pri.zxx.learndemo.trancs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-12-22:19
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestClient {
    @Autowired
    private TranSerivce tranSerivce;

    @Test
    public void myTest() throws InterruptedException {
        String str = "分布式服务--";
        ThreadPoolExecutor ex = new ThreadPoolExecutor(3, 3, 500, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        ex.execute(() -> {
            try {
                tranSerivce.notifyStatus(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ex.execute(() -> {
            try {
                tranSerivce.notufyData(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ex.execute(() -> {
            try {
                tranSerivce.boundData(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(10);
    }
}
