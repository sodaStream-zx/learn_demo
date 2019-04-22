package pri.zxx.learndemo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-04-22-下午 3:41
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisUserMap {
    private static final Logger log = LoggerFactory.getLogger(RedisOpsTest.class);
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void myTest() throws InterruptedException {
        redisTemplate.delete("2-dataMap");
        Long realId = 2L;
        String key = realId + "-dataMap";
        BoundHashOperations userMap = redisTemplate.boundHashOps(key);

        HashMap<String, Integer> myMap = new HashMap();
        myMap.put("新闻", 1);
        myMap.put("微博", 1);
        myMap.put("娃哈哈", 1);
        myMap.put("AD钙奶", 1);
        myMap.put("钢蛋", 1);
        userMap.putAll(myMap);

        String[] types = new String[]{"hah", "新闻", "微博", "娃哈哈", "AD钙奶", "钢蛋"};
        while (true) {
            int i = new Random().nextInt(6);
            System.out.println("随机数：" + i);
            this.incre(types[i]);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void incre(String type) {
        Long realId = 2L;
        String key = realId + "-dataMap";
        BoundHashOperations userMap = redisTemplate.boundHashOps(key);
        userMap.increment(type, 1);
    }
}
