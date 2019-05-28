package pri.zxx.shiro.shirocore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-28-21:24
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FeedBackMapperTest {
    @Resource
    FeedBackMapper feedBackMapper;
    @Autowired
    FeedBackController feedBackController;

    @Test
    public void listOfFeedBacks() {
        List<FeedBack> feedBacks = feedBackMapper.listOfFeedBacks();
        feedBacks.forEach(System.out::println);
    }

    @Test
    public void feedBack() {
        Map<String, Long> stringLongMap = feedBackController.feedBackPath();
        System.out.println(stringLongMap);
    }


    @Test
    public void listOfFeedBacksByTime() {
//        List<FeedBack> list = feedBackMapper.listOfFeedBacksByConditions("2019-05-25", "2019-05-27", "A", "1");
        List<FeedBack> list = feedBackMapper.listOfFeedBacksByConditions(null, null, null, null);
        list.forEach(System.out::println);
    }

    @Test
    public void listOfFeedBacksByPiece() {
        List<FeedBack> list = feedBackMapper.listOfFeedBacksByPiece("方便好用");
        list.forEach(System.out::println);
    }
}