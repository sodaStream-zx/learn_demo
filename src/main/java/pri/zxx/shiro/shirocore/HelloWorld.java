package pri.zxx.shiro.shirocore;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-03-24-22:41
 */
public class HelloWorld {
    public static void main(String[] args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取securityManager实例
        SecurityManager instance = factory.getInstance();
        //绑定securityManager到Utils
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zxx", "1234");
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            System.out.println("登录失败");
            System.out.println(e.getCause() + ":" + e.getMessage());
        }

    }
}
