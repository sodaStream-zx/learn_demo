package pri.zxx.learndemo.httpclientdemo.get;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-07-22:01
 */
public class HtmlUnitRequest implements ISendRequest {
    private static final Logger log = Logger.getLogger(HtmlUnitRequest.class.getName());

    public static void main(String[] args) {
        String url = "http://www.youtube.com/";
        HtmlUnitRequest htmlUnitRequest = new HtmlUnitRequest();
        Document responsePage = htmlUnitRequest.getResponsePage(url);
        System.out.println("responsePage = " + responsePage.text());
    }

    @Override
    public Document getResponsePage(String url) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10000);
        HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
            log.info("htmlpage = = " + htmlPage.getCharset());
            htmlPage.getReadyState();
            webClient.waitForBackgroundJavaScript(10000);
            String htmlString = htmlPage.asXml();
            return Jsoup.parse(htmlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            webClient.close();
        }
    }
}
