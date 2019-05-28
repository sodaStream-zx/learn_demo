package pri.zxx.shiro.shirocore;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-28-20:50
 */
@RestController
@RequestMapping(value = "/feedAnlysis")
public class FeedBackController {
    @Resource
    private FeedBackMapper feedBackMapper;

    //前50个
    @GetMapping(value = "/listOfFeedbacks")
    public Map<String, String> feedBack() {
        List<FeedBack> feedBacks = feedBackMapper.listOfFeedBacks();
        Map<String, Long> labelAndTimes = feedBacks.stream()
                .map(FeedBack::getFeedbackLabel)
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        ArrayList<String> sortedList = new ArrayList<>();
        labelAndTimes.forEach((s, aLong) -> sortedList.add(s + "-" + aLong));
        sortedList.sort(Comparator.comparingInt(value -> Integer.valueOf(value.split("-")[1])));
        Collections.reverse(sortedList);
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        sortedList.stream().limit(50).forEach(s -> result.put(s.split("-")[0], s.split("-")[1]));
        result.forEach((s, s2) -> System.out.println(s + " : " + s2));
        return result;
    }

}
