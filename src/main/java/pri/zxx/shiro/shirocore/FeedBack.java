package pri.zxx.shiro.shirocore;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-28-21:10
 */
public class FeedBack {
    private Long id;
    private String feedbackInfo;
    private Long userId;
    private String feedbackLabel;
    private String createTime;
    private String source;
    private String verison;

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", feedbackInfo='" + feedbackInfo + '\'' +
                ", userId=" + userId +
                ", feedbackLabel='" + feedbackLabel + '\'' +
                ", createTime='" + createTime + '\'' +
                ", source='" + source + '\'' +
                ", verison='" + verison + '\'' +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVerison() {
        return verison;
    }

    public void setVerison(String verison) {
        this.verison = verison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackInfo() {
        return feedbackInfo;
    }

    public void setFeedbackInfo(String feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFeedbackLabel() {
        return feedbackLabel;
    }

    public void setFeedbackLabel(String feedbackLabel) {
        this.feedbackLabel = feedbackLabel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    //    `id` bigint(11) NOT NULL AUTO_INCREMENT,
//  `feedback_info` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '反馈信息',
//            `user_id` bigint(11) NOT NULL DEFAULT '0' COMMENT '关联用户',
//            `feedback_label` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '反馈标签',
//            `create_time`
}
