package cn.contentcl.struts2.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import cn.contentcl.struts2.domain.User;

public class ValueStackDemo4 extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//向值栈中存数据
		//获取值栈的对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//使用push（Object obj）：set（String key, Object obj）；
		User user = new User("赵红","38");
		//向user推入栈顶
		valueStack.push(user);
		
		valueStack.set("name", "张龙"); //创建map集合
		return super.execute();
	}
}
