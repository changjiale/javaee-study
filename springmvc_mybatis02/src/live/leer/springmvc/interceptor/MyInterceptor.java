package live.leer.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 *
 * @author leer
 */
public class MyInterceptor implements HandlerInterceptor {

    //方法执行之后执行
    //设置异常处理清资源，记录日志
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("afterCompletion---------------------");
    }

    //方法执行之后,返回modelAndView之前被执行
    //设置页面的共用参数
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("postHandle----------------------------");
    }

    //进入方法前被执行
    //登录拦截，权限验证
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("preHandle----------------------------");
        return true;
    }

}
