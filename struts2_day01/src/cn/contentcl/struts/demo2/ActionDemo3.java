package cn.contentcl.struts.demo2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的编写方式三： Action类集成ActionSupport类
 * 推荐
 *
 * @author leer
 */

public class ActionDemo3 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("33");
        return NONE;
    }
}
