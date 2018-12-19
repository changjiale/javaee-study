package cn.contentcl.struts.demo2;

import com.opensymphony.xwork2.Action;

/**
 * Action的编写方法2  实现一个Action的接口
 * 实现接口的这种方法：提供5个常量（五个逻辑试图的名称）
 * 	*SUCCESS :成功
 * 	*ERROR	：失败
 * * LOGIN	： 登录出错页面跳转
 * * INPUT  ：表单校验的时候出错
 * * NONE	： 不跳转
 * @author leer 
 *
 */
public class ActionDemo2 implements Action{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("11");
		return NONE;
	}

}
