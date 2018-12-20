package cn.contentcl.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 访问servlet的api方式之一：完全解耦和的方式
 * @author leer
 *
 */

public class RequestDemo1 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// 接受参数
		//利用struts2的对象ActionContext对象
		ActionContext context = ActionContext.getContext();
		//调用ActionContext的方法
		//类似于Map<String,String[]> request.getParmeterMap();
		Map<String,Object> map = context.getParameters();
		for (String key : map.keySet()) {
			String[] values = (String[]) map.get(key);
			System.out.println(key +" "+Arrays.toString(values));
			
		}
		
		
		//二 向域对象中存入数据
		
		context.put("reqName", "reqValue");//相当于request.setAttribute();
		context.getSession().put("sessName", "sessValue");//相当于seesion.setAttribute();
		context.getApplication().put("appName", "appValue"); //相当于application.setAttribute();
		
		return SUCCESS;
	}

}
