package pri.zxx.learndemo.httpclientdemo.get;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-07-21:50
 */
public class SohuNews implements NewsPull {
    private static final Logger logger = Logger.getLogger(SohuNews.class.getName());
    private String url = "http://news.sohu.com/";
    private NewsService newsService = new NewsService();

    public static void main(String[] args) {
        SohuNews sohuNews = new SohuNews();
        sohuNews.pullNews();
    }

    @Override
    public void pullNews() {
        logger.info("开始拉取搜狐新闻！");
        // 1.获取首页
        Document html = null;
        try {
            html = getHtmlFromUrl(url, false);
        } catch (Exception e) {
            logger.warning("==============获取搜狐首页失败: {}=============" + url);
            e.printStackTrace();
            return;
        }
        // 2.jsoup获取新闻<a>标签
        Elements newsATags = html.select("div.focus-news")
                .select("div.list16")
                .select("li")
                .select("a");

        // 3.从<a>标签中抽取基本信息，封装成news
        HashSet<News> newsSet = new HashSet<>();
        for (Element a : newsATags) {
            String url = a.attr("href");
            String title = a.attr("title");
            News n = new News();
            n.setSource("搜狐");
            n.setUrl(url);
            n.setTitle(title);
            n.setDate(new Date());
            newsSet.add(n);
        }
        // 4.根据新闻url访问新闻，获取新闻内容
        newsSet.forEach(news -> {
            logger.info("开始抽取搜狐新闻内容：{}" + news.getUrl());
            Document newsHtml = null;
            try {
                newsHtml = getHtmlFromUrl(news.getUrl(), false);
                Element newsContent = newsHtml.select("div#article-container")
                        .select("div.main")
                        .select("div.text")
                        .first();
                String title = newsContent.select("div.text-title").select("h1").text();
                String content = newsContent.select("article.article").first().toString();
                //String image = NewsUtils.getImageFromContent(content);
                String image = "image";

                news.setTitle(title);
                news.setContent(content);
                news.setImage(image);
                newsService.saveNews(news);
                logger.info("抽取搜狐新闻《{}》成功！" + news.getTitle());
            } catch (Exception e) {
                logger.warning("新闻抽取失败:{}" + news.getUrl());
                e.printStackTrace();
            }
        });
    }
}
