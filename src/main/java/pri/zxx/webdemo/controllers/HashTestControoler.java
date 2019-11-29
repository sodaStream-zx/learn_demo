package pri.zxx.webdemo.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.zxx.webdemo.services.TestService;

import java.util.HashMap;
import java.util.List;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-12-下午 1:39
 */
@RestController
@Api(tags = "Hash测试接口")
public class HashTestControoler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @GetMapping(value = "/hash")
    @ApiOperation(value = "同步url hashcode 到mysql")
    public void insertH() {
        List<String> urls = testService.urls();
        urls.forEach(s -> {
            testService.insertHash(s.hashCode(), s);
            log.warn("insert {}", s);
        });
    }

    @GetMapping(value = "/find")
    @ApiOperation(value = "查询hash 或者urll")
    public HashMap findAv(String hash, String url) {
        HashMap<String, Long> stringLong = new HashMap<>();
        if (!StringUtils.isEmpty(hash)) {
            long st = System.currentTimeMillis();
            List<Integer> hashV = testService.findByHash(hash);
            stringLong.put("hash cost", (System.currentTimeMillis() - st));
            System.out.println("hashv:" + hashV);
        }
        if (!StringUtils.isEmpty(url)) {
            long st = System.currentTimeMillis();
            List<String> urlV = testService.findByUrl(url);
            stringLong.put("url cost ", (System.currentTimeMillis() - st));
            System.out.println("url:" + urlV);
        }
        return stringLong;
    }

    @GetMapping(value = "/hashv")
    @ApiOperation(value = "查询hash 或者urll")
    public List<Integer> hashv(String hash) {
        return testService.findByHash(hash);
    }

    @GetMapping(value = "/url")
    @ApiOperation(value = "查询hash 或者urll")
    public List<String> url(String url) {
        return testService.findByUrl(url);
    }
}
