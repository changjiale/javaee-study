package live.leer.ssh.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import live.leer.ssh.domain.Customer;
import live.leer.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 模型驱动使用的对象:
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	// 注入CustomerService:
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/**
	 * 保存客户的方法：save
	 */
	public String save() {
		// 如果web层没有使用Struts2，获取业务层的类就必须如下进行编写：
		/*WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext.getServletContext());
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");*/
		
		System.out.println("Action中的save方法执行了...");
		customerService.save(customer);
		return NONE;
	}
}
