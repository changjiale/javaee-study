package live.leer.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("进入helloAction 返回默认值");
        return SUCCESS;
    }
}
