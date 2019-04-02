package shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

public class AuthenticationDemo {
    public static void main(String[] args) {
        //加载Shiro的配置文件,返回类型是Factory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:1.ini");

        //获得SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //SecurityUtils用这个工具类将SecurityManager绑定到上下文当中
        SecurityUtils.setSecurityManager(securityManager);
        //用Subject与当前系统交互
        Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken这个对象里面有两个参数，一个用户名，一个密码
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");


        try {
            //用login()方法提交登陆
            subject.login(token);

            //isAuthenticated这个方法判断是否验证
            if (subject.isAuthenticated()) {
                System.out.println("登陆成功");

                //hasRole()方法判断是否有这个角色
                if(subject.hasRole("admin")){
                    System.out.println("有admin角色");
                }else{
                    System.out.println("没有admin这个角色");
                }

                //isPermittedAll()判断是否有多个权限
                if(subject.isPermittedAll("search","add","update")){
                    System.out.println("有这些权限");
                }else{
                    System.out.println("没有有这些权限");
                }

                //isPermitted()判断是否有这个权限
                if (subject.isPermitted("search")){
                    System.out.println("有search权限");
                }else{
                    System.out.println("没有search权限");
                }

            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("用户名或密码错误，登陆失败");
        }
    }
}
