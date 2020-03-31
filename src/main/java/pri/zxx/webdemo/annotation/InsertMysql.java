package pri.zxx.webdemo.annotation;

import java.lang.annotation.*;

/**
 * @author 钢蛋
 * @desc
 * @createTime 2020-03-31-10:03
 */
@Inherited
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface InsertMysql {
    String value() default "";
}
