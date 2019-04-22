package pri.zxx;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import pri.zxx.learndemo.redis.RedisUserMap;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LearnDemoApplication {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    RedisUserMap redisUserMap;

    public static void main(String[] args) {
        SpringApplication.run(LearnDemoApplication.class, args);
    }

    @PostConstruct
    public void redisTemplate() {
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer(Object.class));
        redisTemplate.setKeySerializer(new FastJsonRedisSerializer(Object.class));
        redisTemplate.setHashKeySerializer(new FastJsonRedisSerializer(Object.class));
        redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer(Object.class));
        this.redisUserMap.ConcurrentTest();
    }
}
