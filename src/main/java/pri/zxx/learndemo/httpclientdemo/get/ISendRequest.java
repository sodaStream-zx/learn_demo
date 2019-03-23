package pri.zxx.learndemo.httpclientdemo.get;

import org.jsoup.nodes.Document;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-07-22:01
 */
public interface ISendRequest {
    Document getResponsePage(String url);
}
