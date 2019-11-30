package pri.zxx.learndemo.jdbcdemo.entitys;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-26-下午 4:52
 */
public class Role {
    private String roleName;
    private Integer createBy;
    private String createTime;
    private Long id;
    private Integer enabled;

    @Override
    public String toString() {
        return "User{" +
                "roleName='" + roleName + '\'' +
                ", createBy=" + createBy +
                ", createTime='" + createTime + '\'' +
                ", id=" + id +
                ", enabled=" + enabled +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
