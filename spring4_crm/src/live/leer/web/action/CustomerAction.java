package live.leer.web.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import live.leer.domain.Customer;
import live.leer.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //模型驱动使用的对象
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        // TODO Auto-generated method stub
        return customer;
    }

    /**
     * 跳转到添加页面  saveUI
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 编写保存客户的方法
     */
    public String save() {
        //创建一个工厂类
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
        System.out.println("CustomerActon中放入save方法执行了");
        customerService.save(customer);
        return NONE;
    }

}
