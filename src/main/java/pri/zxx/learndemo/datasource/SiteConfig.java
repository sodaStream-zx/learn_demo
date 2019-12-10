package pri.zxx.learndemo.datasource;

import java.io.Serializable;


public class SiteConfig implements Serializable {
    private static final long serialVersionUID = -7895642865L;
    private int scId;
    //网站名字
    private String siteName;
    //urls
    private String siteUrl;
    //断点
    private boolean res;
    //提取页面规则
    private String pageParse;
    //url提取规则
    private String urlPares;
    //任务入口
    private String seeds;
    //抓取深度
    private Integer deepPath;
    //自动抓取
    private boolean autoParse;
    //数据表名称
    private String tableName;

    public SiteConfig() {
    }

    public SiteConfig(String siteName, String siteUrl, boolean res, String pageParse, String urlPares, String seeds, Integer deepPath, boolean autoParse, String tableName) {
        this.siteName = siteName;
        this.siteUrl = siteUrl;
        this.res = res;
        this.pageParse = pageParse;
        this.urlPares = urlPares;
        this.seeds = seeds;
        this.deepPath = deepPath;
        this.autoParse = autoParse;
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "SiteConfig{" +
                "scId=" + scId +
                ", siteName='" + siteName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", res=" + res +
                ", pageParse='" + pageParse + '\'' +
                ", urlPares='" + urlPares + '\'' +
                ", seeds='" + seeds + '\'' +
                ", deepPath=" + deepPath +
                ", autoParse=" + autoParse +
                ", tableName='" + tableName + '\'' +
                '}';
    }

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getPageParse() {
        return pageParse;
    }

    public void setPageParse(String pageParse) {
        this.pageParse = pageParse;
    }

    public String getUrlPares() {
        return urlPares;
    }

    public void setUrlPares(String urlPares) {
        this.urlPares = urlPares;
    }

    public String getSeeds() {
        return seeds;
    }

    public void setSeeds(String seeds) {
        this.seeds = seeds;
    }

    public Integer getDeepPath() {
        return deepPath;
    }

    public void setDeepPath(Integer deepPath) {
        this.deepPath = deepPath;
    }

    public boolean isAutoParse() {
        return autoParse;
    }

    public void setAutoParse(boolean autoParse) {
        this.autoParse = autoParse;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
