package pri.zxx.learndemo.exceptionhandle;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-21-13:08
 */
//@Component
public class MyExceptionHandle implements HandlerExceptionResolver {
    private static final Logger log = Logger.getLogger(MyExceptionHandle.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("=====================全局异常信息捕获=======================");
        log.info("请求路径::" + request.getProtocol() + request.getRemoteAddr() + request.getRemotePort());
        ex.printStackTrace();
        if (ex instanceof MyException) {
            out.print(ex.toString());
        } else {
            StackTraceElement exObj = ex.getStackTrace()[0];
            MyException myException = new MyException();
            myException.setMsg(ex.getMessage());
            myException.setThrowLocations("类名：" + exObj.getClassName()
                    + "方法：" + exObj.getMethodName()
                    + "行数：" + exObj.getLineNumber());
            myException.setCode("666");
            myException.setRequestUrl(request.getRequestURL().toString());
            out.print(myException.toString());
        }
        out.close();
        return null;
    }
}
