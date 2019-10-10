package pri.zxx.learndemo.my;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * @author zxx
 * @desc 正则匹配hmtl标签
 * @createTime 2019-10-09-下午 4:30
 */
public class HtmlLabelTest {
    private static void parseHtmlToDoc(String htmlDoc) {
        String s = htmlDoc.replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "");
        System.out.println(s);
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        String[] split = htmlDoc.split("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
        Stream.of(split).filter(StringUtils::isNotEmpty).forEach(System.out::println);
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    public static void main(String[] args) {
        String htmlDoc = "<div id=\"Cnt-Main-Article-QQ\" bosszone=\"content\"><p class=\"text\" style=\"TEXT-INDENT:2em\"></p>" +
                "<p align=\"center\"><img src=\"http://inews.gtimg.com/newsapp_bt/0/10476353621/641\" style=\"display:block;\">" +
                "</p><p></p><p class=\"text\" style=\"TEXT-INDENT:2em\"></p><p align=\"center\"><img src=\"http://inews.gtimg.com/newsapp_bt/0/10476353622/641\" " +
                "style=\"display:block;\"></p><p></p><p class=\"text\" style=\"TEXT-INDENT:2em\">昨天，智联招聘发布2019年秋季重庆雇主需求与白领人才供给报告。" +
                "报告显示，2019年第三季度重庆地区的职场竞争态势趋缓，从薪酬水平来看，重庆地区2019年秋季求职期的平均薪酬为8223元/月，整体的平均薪酬水平环比、" +
                "同比上升。</p><p class=\"text\" style=\"TEXT-INDENT:2em\"><strong>重庆地区竞争最激烈的五大行业</strong></p><p class=\"text\" style=\"TEXT-INDENT:2em\">" +
                "从全国来看不同行业的竞争指数，2019年秋季计算机软件行业排名第一，为64.3，绝对值同比上升24.6，网络游戏行业依然位列第二，竞争指数为60.2，同比上升17.3。" +
                "</p><p class=\"text\" style=\"TEXT-INDENT:2em\">数据显示，重庆地区竞争排名前五位的行业中，贸易/进出口行业的竞争指数最高，" +
                "其次是航空/航天研究与制造行业，交通/运输行业排在第三，物流/仓储行业和房地产/建筑/建材/工程行业的竞争指数位列第四和第五。</p>" +
                "<p class=\"text\" style=\"TEXT-INDENT:2em\">重庆地区竞争最激烈的五大职业</p><p class=\"text\" style=\"TEXT-INDENT:2em\">从不同城市的竞争指数来看，" +
                "在智联招聘监测的全国38个主要城市中，2019年秋季求职期，北京的竞争指数仍然排在第一位，为116.7，且同比增长41.7。重庆在全国38个主要城市中排名第18位。</p>" +
                "<p class=\"text\" style=\"TEXT-INDENT:2em\">数据显示，重庆地区2019年秋季竞争最激烈的职业是IT质量管理/测试/配置管理、交通运输服务和行政/后勤/文秘。</p>" +
                "<p class=\"text\" style=\"TEXT-INDENT:2em\">此外，财务/审计/税务和汽车制造的竞争也较为激烈。IT质量管理/测试/配置管理和交通运输服务的竞争指数环比下降" +
                "，本季度排名互换，竞争激烈。行政/后勤/文秘和财务/审计/税务的竞争指数环比下降，本季度也互换排名。汽车制造竞争指数环比下降、同比上升，排名由上季度第九名" +
                "上升至本季度第五。</p><p class=\"text\" style=\"TEXT-INDENT:2em\"><strong>重庆地区的十大高薪行业</strong></p>" +
                "<p class=\"text\" style=\"TEXT-INDENT:2em\">智联招聘在线数据显示，重庆地区2019年秋季求职期的平均薪酬为8223元/月，" +
                "在全国38个主要城市的薪酬水平中排名第十六位，薪酬水平较上一季度略有上升。</p><p class=\"text\" style=\"TEXT-INDENT:2em\">从薪酬的分布情况来看，" +
                "重庆地区薪酬水平较高，平均月薪4001元/月至6000元/月的职位占职位总量的29.2%，8000元以上/月的占34.1%。</p><p class=\"text\" style=\"TEXT-INDENT:2em\">" +
                "具体来看，基金/证券/期货/投资的平均月薪最高，为10912元/月；其次为跨领域经营，薪酬水平为10577元/月；再次是礼品/玩具/工艺美术/收藏品/奢侈品行业，" +
                "平均月薪为10257元。重庆地区平均薪资排名前十的行业，基金/证券/期货/投资和跨领域经营行业的平均薪资水平及排名略有提升；礼品/玩具/工艺美术/收藏品/奢侈品" +
                "、学术/科研和信托/担保/拍卖/典当行业的平均薪资水平及排名有所下降；保险行业发展迅速，进入薪酬前十的榜单。</p><p class=\"text\" " +
                "style=\"TEXT-INDENT:2em\">重庆晨报·上游新闻记者 林祺</p></div>";
        String htmlDoc2 = "<div id=\"Cnt-Main-Article-QQ\" bosszone=\"content\"><p class=\"text\" style=\"TEXT-INDENT:2em\"></p>" +
                "<p align=\"center\"><img src=\"http://inews.gtimg.com/newsapp_bt/0/10479806712/641\" style=\"display:block;\"></p>" +
                "<p align=\"center\" class=\"text image_desc\">雨水告一段落，乌云还未退散。华龙网-新重庆客户端记者 李裕锟 摄</p><p></p>" +
                "<p class=\"text\" style=\"TEXT-INDENT:2em\">华龙网-新重庆客户端讯（记者 董进）近日，重庆大部地区持续阴雨天气，开州、巫溪、城口雨势最强。" +
                "重庆市气象台预计，新一轮降雨将袭击山城，或持续到11日夜间，东北部局地可能有暴雨出没，当地需注意防范地质灾害。</p><p class=\"text\" s" +
                "tyle=\"TEXT-INDENT:2em\">据重庆市气象台统计，10月3日至7日，重庆大部地区持续阴雨天气，降水主要集中在长江沿线以北地区，" +
                "其中东北部地区平均降水量达91.3毫米，较常年同期（10月上旬）35.5毫米显著偏多1至2倍，较去年同期（10月上旬）17.0毫米显著偏多4至5倍。" +
                "3日20时至8日8时，开州、巫溪、城口等3个区县的14个雨量站的累计雨量超过250毫米。</p><p class=\"text\" style=\"TEXT-INDENT:2em\">受切变线和冷空气共同影响，" +
                "重庆市气象台预计，9日夜间至11日夜间，重庆部分地区有较强降雨，东北部地区中雨到大雨，局地暴雨，东南部地区中雨，局地大雨，" +
                "并伴有雷电和局地阵性大风等强对流天气。过程累计雨量东北部地区40~80毫米，局地100毫米以上，东南部地区25~45毫米，中西部地区5~25毫米。" +
                "届时，全市最高气温将降至25℃，主城最高气温仅23℃。</p><p class=\"text\" style=\"TEXT-INDENT:2em\">气象专家提醒，前期重庆东北部地区降雨持续时间长、" +
                "局地累计雨量大，未来上述地区仍有较强降雨，地质灾害气象风险高，建议加强可能引发的山体滑坡、崩塌等次生灾害的防范工作。另外，未来一周重庆多阴雨天气，" +
                "大家需注意防范降雨对农业生产造成的不利影响。</p><p class=\"text\" style=\"TEXT-INDENT:2em\"><strong>未来三天天气：</strong></p><p class=\"text\"" +
                " style=\"TEXT-INDENT:2em\">9日夜间到10日白天，东北部地区中雨到大雨，局地暴雨，中西部地区阵雨，东南部地区阴天转阵雨。大部分地区气温15~25℃，" +
                "城口及东南部12~23℃。主城区：阵雨，气温19~22℃。</p><p class=\"text\" style=\"TEXT-INDENT:2em\">10日夜间到11日白天，东部地区中雨到大雨，" +
                "西部偏西地区阵雨转阴天，其余地区阵雨。大部分地区气温14~24℃，城口及东南部11~21℃。主城区：阵雨，气温18~21℃。</p><p class=\"text\" " +
                "style=\"TEXT-INDENT:2em\">11日夜间到12日白天，东南部中雨到大雨，西部偏西及东北部偏北地区阵雨转阴天，其余地区阵雨。大部分地区气温14~25℃" +
                "，城口及东南部11~21℃。主城区：阵雨转阴天，气温18~22℃。<a href=\"http://www.qq.com/?pref=article\" target=\"_blank\" title=\"点击进入腾讯首页\" " +
                "id=\"backqqcom\" style=\"white-space: nowrap; display: none;\"><img src=\"http://www.qq.com/favicon.ico\" width=\"16\" height=\"16\">" +
                "<span style=\"padding-left: 5px; font-size: 14px;\">返回腾讯网首页&gt;&gt;</span></a></p></div>";
        HtmlLabelTest.parseHtmlToDoc(htmlDoc);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        HtmlLabelTest.parseHtmlToDoc(htmlDoc2);
    }


}
