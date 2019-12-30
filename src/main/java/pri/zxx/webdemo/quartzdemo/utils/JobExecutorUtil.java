package pri.zxx.webdemo.quartzdemo.utils;

import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author zxx
 * @desc
 * @createTime 2019-12-30-下午 2:14
 */
public class JobExecutorUtil {
    public static void invokeJob(String url) {
        RestTemplate bean = SpringUtils.getBean("restTemplate");
        String forObject = bean.getForObject(url, String.class);
        byte[] bytes = forObject.getBytes();
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
