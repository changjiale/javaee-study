package cn.contentcl.struts2.demo2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.contentcl.struts2.domain.User;

public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	
	//模型驱动使用的对象，前提必须手动提供对象的实例
	private User user = new User(); //手动实例化User
	@Override
	//模型驱动需要使用的方法
	public User getModel() {
		
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
	
}
