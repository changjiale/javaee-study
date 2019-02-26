package cn.contentcl.web.action;

import org.apache.struts2.ServletActionContext;

import cn.contentcl.domain.User;
import cn.contentcl.service.UserService;
import cn.contentcl.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户的Action的类
 *
 * @author jt
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    // 接收数据:
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    /**
     * 用户登录的方法:
     */
    public String login() {
        System.out.println(user);
        // 调用业务层:
        UserService userService = new UserServiceImpl();
        User existUser = userService.login(user);
        // 根据结果页面跳转：
        //System.out.println(existUser);
        if (existUser == null) {
            // 登录失败
            // ActionError、FieldError、ActionMessage
            this.addActionError("用户名或密码错误！");
            return LOGIN;
        } else {
            // 登录成功
            // ActionContext.getContext().getSession().put("existUser", "existUser");
            ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            return SUCCESS;
        }
    }


}

