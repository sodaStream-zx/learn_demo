package pri.zxx.learndemo.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;
import java.util.UUID;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-13-19:36
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisOpsTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void delete() {
        String key = "test*";
        Set keys = redisTemplate.keys(key);
        System.out.println("sieze:" + keys.size());
        keys.stream().forEach(k -> redisTemplate.delete(k));
    }

    @Test
    public void insert() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        if (connection.isClosed()) {
            System.out.println("未连接上redis");
        }
        for (int i = 0; i < 20000; i++) {
            redisTemplate.opsForValue().set("test" + i, UUID.randomUUID().toString());
            redisTemplate.opsForValue().set("pro" + i, UUID.randomUUID().toString());
        }
        Set keys = redisTemplate.keys("test*");
        System.out.println("size:" + keys.size());
    }
}
