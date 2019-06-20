package pri.zxx.webdemo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-06-16-14:17
 */
public class SysRole {
    @ApiModelProperty(name = "id", value = "id")
    private Long id;
    @ApiModelProperty(name = "role_name", value = "角色名称")
    private String role_name;
    @ApiModelProperty(name = "enabled", value = "是否启用")
    private Integer enabled;
    @ApiModelProperty(name = "create_time", value = "创建时间", notes = "yyyy-MM-DD")
    private LocalDateTime create_time;
    @ApiModelProperty(name = "create_by", value = "c创建者", notes = "yyyy-MM-DD")
    private Long create_by;

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", enabled=" + enabled +
                ", create_time=" + create_time +
                ", create_by=" + create_by +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }
}
