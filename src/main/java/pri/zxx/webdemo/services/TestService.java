package pri.zxx.webdemo.services;

import org.springframework.stereotype.Service;
import pri.zxx.webdemo.entity.SysRole;
import pri.zxx.webdemo.mappers.TestMapper;

import javax.annotation.Resource;

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
}
