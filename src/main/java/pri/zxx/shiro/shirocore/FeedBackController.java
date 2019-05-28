package pri.zxx.shiro.shirocore;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(FeedBackController.class);
    @Resource
    private FeedBackMapper feedBackMapper;

    //前50个
    @GetMapping(value = "/listOfFeedbacks")
    public Map<String, Long> feedBackPath() {
        log.warn("查询所有反馈标签{}");
        List<FeedBack> feedBacks = feedBackMapper.listOfFeedBacks();
        Map<String, Long> labelAndTimes = feedBacks.stream()
                .map(FeedBack::getFeedbackLabel)
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        List<Map.Entry<String, Long>> results = labelAndTimes.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> value.getValue()))
                .limit(50).collect(Collectors.toList());
        Collections.reverse(results);
        LinkedHashMap<String, Long> resultMap = new LinkedHashMap<>();
        results.forEach(se -> resultMap.put(se.getKey(), se.getValue()));
        return resultMap;
    }

    //按标签查询
    @GetMapping(value = "/listByPiece")
    public List<FeedBack> listByPiecePath(String piece) {
        log.warn("接收到参数 piece {}", piece);
        return feedBackMapper.listOfFeedBacksByPiece(piece);
    }

    //按条件查询
    @GetMapping(value = "/listByConditions")
    public List<FeedBack> listByconditionsPath(String startTime, String endTime, String source, String version) {
        log.warn("接收到参数startTime {} endTime {} source {} version {}", startTime, endTime, source, version);
        return feedBackMapper.listOfFeedBacksByConditions(startTime, endTime, source, version);
    }
}
