package pri.zxx.webdemo.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pri.zxx.webdemo.entity.SysRole;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-06-16-14:00
 */
@Mapper
public interface TestMapper {
    /*
        private Long id;
        private String role_name;
        private Integer enabled;
        private LocalDateTime create_time;
        private Long create_by;
    */
    @Insert(value = "insert into sys_role (role_name,enabled,create_time,create_by) values (" +
            "#{u.role_name},#{u.enabled},#{u.create_time},#{u.create_by}" +
            ")")
    Integer insert(@Param(value = "u") SysRole u);

}
