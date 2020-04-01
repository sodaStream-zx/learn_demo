package pri.zxx.myaopdemo.annotation;

import java.lang.annotation.*;

//参数
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ExtParam {
    String value();
}