package pri.zxx.learndemo.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc httpClient 学习
 * @createTime 2019-01-03-22:12
 */
public class HttpclientDemo {
    private static final Logger log = Logger.getLogger(HttpclientDemo.class.getName());

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        //String url = "https://www.jb51.net/";
        //String url = "https://www.csdn.net/nav/fund0";
        //String url = "https://blog.csdn.net/hpdlzu80100/article/details/85554880";
        String url = "https://baijiahao.baidu.com/s?id=1589546094825996322&wfr=spider&for=pc";
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
            byte[] content = bos.toByteArray();
            String coding = CharsetDetector.guessEncoding(content);
            String html = new String(content, coding);
            log.info("网页内容：：\n" + entity.getContentEncoding() + ";" + entity.getContentType());
            log.info("响应状态栏：：\n" + response.getStatusLine() + ";");
            log.info("编码：：\n" + coding + ";");
            log.info("content lenght：：\n" + content.length + ";");
            log.info("content ：：\n" + html + ";");
            log.info("html = " + html);
            log.info("httpget = " + httpGet.getConfig().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
