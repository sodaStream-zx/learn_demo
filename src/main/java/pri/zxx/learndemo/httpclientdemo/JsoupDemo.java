package pri.zxx.learndemo.httpclientdemo;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc jsoup 基础学习
 * @createTime 2019-01-03-22:12
 */
public class JsoupDemo {
    private static final Logger log = Logger.getLogger(JsoupDemo.class.getName());

    public static Document getDoc(String url) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).build();
        try {
            httpGet.setConfig(config);
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();
            BufferedInputStream bi = new BufferedInputStream(in);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read;
            while ((read = bi.read()) != -1) {
                bos.write(read);
            }
            response.close();
            client.close();
            byte[] content = bos.toByteArray();
            String coding = CharsetDetector.guessEncoding(content);
            String html = new String(content, coding);
            return StringUtils.isBlank(html) ? null : Jsoup.parse(html, url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "https://www.jb51.net/";
        Document doc = JsoupDemo.getDoc(url);
        Element els = doc.getElementsByTag("title").get(0);
        log.info("by Tag:" + els.text());
        List<String> ids = doc.select("a[href]").eachAttr("abs:href");
        for (String x : ids) {
            System.out.println(x);
            // System.out.println(x.absUrl("href"));
        }
        //log.info("doc" + doc);
    }
}
