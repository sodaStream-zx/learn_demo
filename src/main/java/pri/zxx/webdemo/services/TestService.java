package pri.zxx.webdemo.services;

import org.springframework.stereotype.Service;
import pri.zxx.webdemo.entity.SysRole;
import pri.zxx.webdemo.mappers.TestMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-06-16-14:00
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public Integer insertOne(SysRole sysRole) {
        return testMapper.insert(sysRole);
    }

    public Integer insertHash(Integer hashv, String url) {
        return testMapper.insertHash(hashv, url);
    }

    public List<Integer> findByHash(String hash) {
        return testMapper.findByHash(hash);
    }

    public List<String> findByUrl(String url) {
        return testMapper.findByUrl(url);
    }

    public List<String> urls() {
        return testMapper.urls();
    }
}
