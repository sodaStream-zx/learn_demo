package pri.zxx.learndemo.redis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-04-16-下午 3:21
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @org.junit.Test
    public void test() {
        String name = "process";
//        String value = "36-1-1555397372191";
//        String value2 = "35-1-1555397372191";
//        String value3 = "37-1-21342354235";
        redisTemplate.delete(name);
        BoundHashOperations pro = redisTemplate.boundHashOps(name);

//        pro.putIfAbsent(1, value);
//        pro.putIfAbsent(2, value2);
//        Map redisMap = pro.entries();
//        redisMap.forEach((o, o2) -> System.out.println(o + " : " + o2));
//
//        Object o = pro.get(2);
//        System.out.println("o=" + o);
//        pro.put(2, o + "," + value3);
//        Object o2 = pro.get(2);
//        System.out.println("o2=" + o2);
        //用户 1，2，3，4，5
        //任务 a,b,c,d
        String A = "this is A task";
        String B = "this is B task";
        String C = "this is C task";
        String D = "this is D task";

        //1用户测试A
        pro.put(1, A);
        //2用户测试B
        pro.put(2, B);
        //3 用户想测试A  先从map中查询是否有人正在测试A
        Map<Integer, String> entries = pro.entries();
        Collection<String> values = entries.values();
        List<String> a1 = values.stream().filter(s -> s.contains("A")).collect(Collectors.toList());
//        Stream.of(entries.values()).anyMatch(collection -> collection.contains("A"));
        if (a1.size() > 0) {
            pro.put(3, a1.get(a1.size() - 1));
        }
        pro.entries().forEach((i, j) -> System.out.println(i + " : " + j));

    }
}
