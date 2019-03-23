package pri.zxx.learndemo.httpclientdemo.get;

import java.util.Date;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-07-21:24
 */
public class News {
    private String source;
    private Date date;
    private String url;
    private String image;
    private String title;
    private String content;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "source='" + source + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
