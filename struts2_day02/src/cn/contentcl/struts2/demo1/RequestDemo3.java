package cn.contentcl.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问servlet的api三  接口注入的方式
 * @author leer
 *
 */
public class RequestDemo3 extends ActionSupport implements ServletRequestAware,ServletContextAware{
	private HttpServletRequest request;
	private ServletContext context;
	@Override
	public String execute() throws Exception {
		
		//一接受参数
		//通过接口的注入的方式获得request对象
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key+"    "+Arrays.toString(values));
		}
		
		// 二、向域对象中保存数据
		// 向request中保存数据:
		request.setAttribute("reqName", "reqValue");
		// 向session中保存数据
		request.getSession().setAttribute("sessName", "sessValue");
		// 向application中保存数据
		context.setAttribute("appName", "appValue");
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}
	
	//补充：servlet是单例的多个程序访问一个servlet只会创建一个servlet实例，但Action是多例的，所以不会不会出现线程安全

	
	
}
