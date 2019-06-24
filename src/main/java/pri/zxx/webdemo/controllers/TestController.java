package pri.zxx.webdemo.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pri.zxx.webdemo.entity.SysRole;
import pri.zxx.webdemo.services.TestService;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-06-16-14:00
 */
@RestController
@Api(tags = "测试接口")
public class TestController {
    private static final Logger log = Logger.getLogger(TestController.class);
    private static String[] name = new String[]{"张三", "李四", "王二", "血不染", "持之不败", "随心不欲"};
    @Autowired
    private TestService testService;

    @GetMapping(value = "/insert")
    @ApiOperation(value = "测试插入指定数量数据")
    @ApiImplicitParams(@ApiImplicitParam(name = "count", value = "数量", required = false))
    public String toInsert(Integer count, SysRole sysRole1) {
        Long st = System.currentTimeMillis();
        SysRole sysRole = null;
        if (count == null) {
            return "ok";
        }
        for (int i = 0; i < count; i++) {
            sysRole = new SysRole();
            sysRole.setRole_name(name[new Random().nextInt(6)]);
            sysRole.setEnabled(new Random().nextInt(2));
            sysRole.setCreate_time(LocalDateTime.now().minusMonths(Long.valueOf(i)).format(DateTimeFormatter.ISO_DATE));
            sysRole.setCreate_by(Long.valueOf(i));
            testService.insertOne(sysRole);
        }
        log.warn((System.currentTimeMillis() - st));
        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("用时", System.currentTimeMillis() - st);
        map.put("model", sysRole);
        return JSON.toJSONString(map, SerializerFeature.PrettyFormat);
    }

    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public String handleFileUpload(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                log.warn(file.getOriginalFilename());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
