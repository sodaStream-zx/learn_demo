package pri.zxx.webdemo.aops;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pri.zxx.webdemo.annotation.InsertMysql;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author 钢蛋
 * @desc
 * @createTime 2020-03-31-10:09
 */
@Aspect
@Component
public class MysqlAopAspect {


    /**
     * 插入数据切面
     */
    @Pointcut(value = "@annotation(pri.*.*.annotation.InsertMysql)")
    public void insertMysqlAnn() {
    }

    /**
     * 删除数据切面
     */
    @Pointcut(value = "@annotation(pri.*.*.annotation.DeleteMysql)")
    public void deleteMysqlAnn() {
    }

    /**
     * 查询数据切面
     */
    @Pointcut(value = "@annotation(pri.*.*.annotation.SelectMysql)")
    public void selectMysqlAnn() {
    }

    /**
     * 更新数据切面
     */
    @Pointcut(value = "@annotation(pri.*.*.annotation.NotifyMysql)")
    public void notifyMysqlAnn() {
    }

    /*----------------------  插入数据处理 -----------------------*/
    @Around(value = "insertMysqlAnn()")
    public Object insetData(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = ms.getMethod();
        InsertMysql annotation = method.getAnnotation(InsertMysql.class);
        String sql = annotation.value();
        Parameter[] parameters = method.getParameters();
        //解析sql组装参数
        //调用jdbc插入数据
        return proceedingJoinPoint.proceed();
    }

}

