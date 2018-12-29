package cn.contentcl.struts2.valuestack;

import com.opensymphony.xwork2.ActionSupport;

import cn.contentcl.struts2.domain.User;
/**
 * 操作valueStack 方法一  利用Action本身在值栈中的特性
 * @author leer
 *
 */
public class ValueStackDemo3 extends ActionSupport{
	private User user;
	
	
	public User getUser() {
		return user;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//向valueSTACK中存值
		user = new User("李冰","222s");
		
		return SUCCESS;
	}

}
