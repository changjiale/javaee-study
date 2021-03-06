package live.leer.springmvc.exception;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 *
 * @author leer
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        // TODO Auto-generated method stub
        String result = "系统发生异常，请联系管理员";
        if (ex instanceof MyException) {
            result = ((MyException) ex).getMsg();
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", result);
        mav.setViewName("msg");
        return mav;
    }

}
