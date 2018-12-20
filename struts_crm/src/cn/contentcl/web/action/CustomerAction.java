package cn.contentcl.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.contentcl.domain.Customer;
import cn.contentcl.service.CustomerService;
import cn.contentcl.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport{
	public String find() {
		//调用业务层
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> list = customerService.find();
		// 页面跳转
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findSuccess";
	}
}
