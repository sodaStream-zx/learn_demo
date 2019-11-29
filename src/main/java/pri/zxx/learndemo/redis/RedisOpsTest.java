package pri.zxx.learndemo.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-13-19:36
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisOpsTest {
    private static final Logger log = LoggerFactory.getLogger(RedisOpsTest.class);
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void delete() {
        String key = "*-dataMap";
        Set keys = redisTemplate.keys(key);
        System.out.println("sieze:" + keys.size());
        keys.forEach(k -> redisTemplate.delete(k));
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
        assert keys != null;
        System.out.println("size:" + keys.size());
    }

    @Test
    public void list() {
        redisTemplate.delete("testList");
        String[] tlist = new String[]{"12-1-125688498454", "13-2-125688498454", "14-3-125688498454", "15-4-125688498454", "16-5-125688498454"};
        BoundListOperations lo = redisTemplate.boundListOps("testList");
        Long testList = lo.leftPushAll(tlist);
        Long aLong = lo.leftPush("17-1-smksicnaslasd");
        System.out.println("along=" + aLong);
        System.out.println("leng:" + testList);
        System.out.println("--------");
        List<String> list = lo.range(0, -1);
        list.forEach(System.out::println);

    }

    @Test
    public void map() {
        redisTemplate.delete("testMap");
        HashMap<String, String> tMap = new HashMap<>();
        tMap.put("12-1-125688498454", UUID.randomUUID().toString());
        tMap.put("14-3-125688498454", UUID.randomUUID().toString());
        tMap.put("15-4-125688498454", UUID.randomUUID().toString());
        tMap.put("16-5-125688498454", UUID.randomUUID().toString());
        tMap.put("5-5-125688498454", UUID.randomUUID().toString());
        tMap.put("4-2-125688498454", UUID.randomUUID().toString());
        tMap.put("3-76-125688498454", UUID.randomUUID().toString());
        BoundHashOperations testMap = redisTemplate.boundHashOps("testMap");
        testMap.putAll(tMap);

        log.warn("获取vip定时任务进度条-------");
        Optional<String> index = this.getVipProgress(17L);
        log.warn("index = {}", index.orElse("Nothing"));

        log.warn("删除vip进度条-------");
        Optional<List<String>> strings = this.deleteVipProgress(18L);
        if (strings.isPresent()) {
            log.warn("删除成功");
        } else {
            log.warn("未能找到对应进度条");
        }
    }

    //新增进度条
    public void insertVipProgress(String imie) {
        redisTemplate.opsForHash().put("testMap", imie, UUID.randomUUID().toString());
    }

    //获取进度条
    public Optional<String> getVipProgress(Long realId) {
        BoundHashOperations testMap = redisTemplate.boundHashOps("testMap");
        Set<String> keys = testMap.keys();
        List<String> targetPros = keys.stream()
                .filter(s -> s.startsWith(String.valueOf(realId)))
                .collect(Collectors.toList());
        if (targetPros.size() > 0) {
            String pro = targetPros.get(targetPros.size() - 1);
            log.warn("vip任务队列 获取到realId {} 进度条 {}", realId, pro);
            return Optional.of(pro);
        } else {
            return Optional.empty();
        }
    }

    //删除进度条
    public Optional<List<String>> deleteVipProgress(Long realId) {
        BoundHashOperations testMap = redisTemplate.boundHashOps("testMap");
        Set<String> keys = testMap.keys();
        List<String> strings = keys.stream()
                .filter(s -> s.startsWith(String.valueOf(realId)))
                .collect(Collectors.toList());
        if (strings.size() > 0) {
            Long aLong = testMap.delete(strings.toArray());
            log.warn("删除realId {} 对应进度条个数 {}", realId, aLong);
            return Optional.of(strings);
        } else {
            log.warn("realId {} 没有vip定时任务进度条", realId);
            return Optional.empty();
        }
    }
}
