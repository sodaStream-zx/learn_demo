package pri.zxx.learndemo.httpclientdemo;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author 一杯咖啡
 * @desc HtmlUnit 基础学习
 * @createTime 2019-01-03-22:12
 */
public class HtmlUnitDemo {
    private static final Logger log = Logger.getLogger(HtmlUnitDemo.class);

    public static void main(String[] args) throws IOException {
        String url = "https://www.toutiao.com/";
        //Document doc = JsoupDemo.getDoc(url);
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10000);
        HtmlPage htmlPage = null;
        try {
            htmlPage = webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(10000);
            String htmlString = htmlPage.asXml();
            Document doc = Jsoup.parse(htmlString);
            log.info("doc = " + doc);
        } finally {
            webClient.close();
        }

        /*Document doc = Jsoup.parse(html.getWebResponse().getContentAsString());
        Element els = doc.getElementsByTag("title").get(0);
        log.info("by Tag:" + els.text());
        List<String> ids = doc.select("a[href]").eachAttr("abs:href");
        for (String x : ids) {
            System.out.println(x);
            // System.out.println(x.absUrl("href"));
        }*/
    }
}
