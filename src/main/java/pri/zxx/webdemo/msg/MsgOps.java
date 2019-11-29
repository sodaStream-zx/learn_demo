package pri.zxx.webdemo.msg;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zxx
 * @desc 消息处理
 * @createTime 2019-08-08-下午 1:59
 */
@Service
public class MsgOps {

    private static final String MSGHASHMAP = "msgStatusHashMap";
    private static final String MSGCOM = "comHashMap";
    private static final Logger log = LoggerFactory.getLogger(MsgOps.class);
    @Value(value = "${msg.timeOut}")
    private Integer timeOut;
    @Autowired
    private RedisTemplate redisTemplate;

    //接收消息 并处理
    public void gainMsg(String msg) {
        log.warn("------start--------收到消息{}", msg);
        if (StringUtils.isEmpty(msg)) {
            return;
        }
        boolean contains = msg.contains("status");
        if (contains) {
            //json数据
            if (this.checkMissonStatus(msg)) {
                /*-------发送rabbit 并清除状态机---------*/
                this.sendToRabbit(msg);
                this.clearStatus(msg);
            } else {
                //定时 并 存储 (此处必先定时再存储，否则会出现多线程操作异常)
                this.time(msg);
                this.storeUnMsg(msg);
            }
        } else {
            //非json数据
            /*------- 存储 -> 获取对应完成状态 ->检查是否可以发送->发送---------*/
            this.storeStatusMsg(msg);
            String json = this.getUnMsg(msg);
            if (json != null) {
                if (this.checkMissonStatus(json)) {
                    this.sendToRabbit(json);
                    this.clearStatus(json);
                }
            }
        }
    }

    //定时
    public void time(String json) {
        redisTemplate.opsForValue().set(json, UUID.randomUUID().toString(), timeOut, TimeUnit.SECONDS);
    }

    //状态消息 放入hash中
    public void storeStatusMsg(String msg) {
        redisTemplate.opsForHash().increment(MSGHASHMAP, msg, 1);
    }

    //非状态消息 放入另一个map中
    public void storeUnMsg(String msg) {
        redisTemplate.opsForHash().put(MSGCOM, msg, 1);
    }

    //获取状态消息
    public String getUnMsg(String ImieMsg) {
        Set<Object> keys = redisTemplate.opsForHash().keys(MSGCOM);
        Optional<Object> any = keys.stream()
                .filter(o -> !ObjectUtils.isEmpty(o))
                .filter(o -> {
                    //解析json
                    HashMap<String, String> hashMap = JSON.parseObject(o.toString(), HashMap.class);
                    String imie = hashMap.get("imie");
                    return ImieMsg.contains(imie);
                }).findAny();
        return any.orElse(null).toString();
    }

    //清除状态机队列
    private void clearStatus(String json) {
        //解析json
        HashMap<String, String> hashMap = JSON.parseObject(json, HashMap.class);
        String imie = hashMap.get("imie");
        redisTemplate.opsForHash().delete(MSGCOM, json);
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(MSGHASHMAP);
        boundHashOperations.entries().forEach((o, o2) -> {
            if (o.toString().startsWith(imie)) {
                boundHashOperations.delete(MSGHASHMAP, o.toString());
            }
        });

    }

    //监测是否该发送json到消息队列
    public Boolean checkMissonStatus(String json) {
        String imie;
        //解析json
        HashMap<String, String> hashMap = JSON.parseObject(json, HashMap.class);
        imie = hashMap.get("imie");
        /*---------获取hash中对应的 imie 是否结束--------------*/
        List<String> imies = new ArrayList<>();
        Map entries = redisTemplate.opsForHash().entries(MSGHASHMAP);
        if (entries.size() > 0) {
            entries.forEach((o, o2) -> imies.add(o + "+" + o2));
            boolean allowedSendToRabbit;
            List<String> collect = imies.stream()
                    .filter(s -> !StringUtils.isEmpty(s))
                    .filter(s -> s.startsWith(imie)).collect(Collectors.toList());
            allowedSendToRabbit = collect.stream().allMatch(s -> s.endsWith("+2"));
            if (allowedSendToRabbit) {
                System.out.println(collect);
                log.warn("check json {} -->>PASS", json);
            }
            return allowedSendToRabbit;
        }
        return false;
    }

    //发送到rabbit中
    public void sendToRabbit(String json) {
        //TODO
        log.warn("发送到rabbitmq中 {}", json);
    }

    //每秒循环检查
    public void loopCheck() throws InterruptedException {
        while (true) {
            Map entries = redisTemplate.opsForHash().entries(MSGCOM);
            entries.forEach((o, o2) -> {
                Boolean aBoolean = redisTemplate.hasKey(o);
                if (!aBoolean) {
                    log.warn("超时直接发送json");
                    this.sendToRabbit(o.toString());
                    this.clearStatus(o.toString());
                }
            });
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
