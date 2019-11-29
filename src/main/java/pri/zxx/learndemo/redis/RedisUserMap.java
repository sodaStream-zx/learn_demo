package pri.zxx.learndemo.redis;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc
 * @createTime 2019-04-22-下午 3:41
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@Service
public class RedisUserMap {
    private static final Logger log = LoggerFactory.getLogger(RedisOpsTest.class);
    @Autowired
    RedisTemplate redisTemplate;

    //缓存map
//    ConcurrentHashMap<Long, HashMap<String, Integer>> cacheData = new ConcurrentHashMap<>();
    @org.junit.Test
    public void ConcurrentTest() {
//        new Thread(() -> this.myTest(1L), "test-1").start();
//        new Thread(() -> this.myTest(3L), "test-2").start();
//        new Thread(() -> this.myTest(5L), "test-2").start();
//        new Thread(() -> this.myTest(7L), "test-2").start();
//        new Thread(() -> this.myTest(9L), "test-2").start();
        this.myTest(1L);
        System.out.println("over");
    }

    //数据增加
    public void increType(Long realId, String type) {
        BoundHashOperations ops = redisTemplate.boundHashOps(realId + "-dataMap");
        log.warn("type {} 增加 1", type);
        ops.increment(type, 1);
    }

    //    @Test
    public void myTest(Long realId) {
//        redisTemplate.delete("2-dataMap");
        String[] types = new String[]{"haha", "新闻", "微博", "娃哈哈", "AD钙奶", "钢蛋"};
        for (int i = 0; i < 50; i++) {
            System.out.println("循环第 " + i + " 次");
            int r = new Random().nextInt(6);
//            System.out.println("随机数：" + r);
//            this.throughCache(realId, types[r]);
            increType(realId, types[r]);
            this.getMap(realId);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.copyMap(realId, realId + 1);
    }


    //缓存平台
    public void throughCache(Long realId, String type) {
        BoundHashOperations ops = redisTemplate.boundHashOps(realId + "-dataMap");
        BoundHashOperations cacheMap = redisTemplate.boundHashOps(realId + "-cacheData");
        //缓存中大小
        Integer cacheNum = cacheMap.get(type) != null ? (Integer) cacheMap.get(type) : 0;
        //redis中大小
        Integer redisNum = ops.get(type) != null ? (Integer) ops.get(type) : 0;
        if (redisNum != 0 && cacheNum < redisNum) {
            //缓存增加1
            cacheMap.put(type, cacheNum + 1);
        } else {
            //redis增加 这里缓存也要同步增加。
            cacheMap.put(type, cacheNum + 1);
            ops.increment(type, 1);
        }
    }

    //远程清空缓存
    public Boolean deleteCache(Long realId) {
        return redisTemplate.delete(realId + "-cacheData");
    }

    //复制
    public void copyMap(Long fromId, Long toId) {
        Map<String, Integer> fromMap = redisTemplate.opsForHash().entries(fromId + "-dataMap");
        redisTemplate.opsForHash().putAll(toId + "-dataMap", fromMap);
    }

    //获取结果
    public Map<String, Integer> getMap(Long realId) {
        Map<String, Integer> map = redisTemplate.opsForHash().entries(realId + "-dataMap");
        System.out.println(map.toString());
        return map;
    }
}
