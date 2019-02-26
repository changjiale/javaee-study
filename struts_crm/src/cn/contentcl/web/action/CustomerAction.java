package cn.contentcl.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.contentcl.domain.Customer;
import cn.contentcl.service.CustomerService;
import cn.contentcl.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    //模型驱动所需要的对象
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        // TODO Auto-generated method stub
        return customer;
    }

    public String find() {
        //调用业务层
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> list = customerService.find();
        // 页面跳转
        //ServletActionContext.getRequest().setAttribute("list", list);

        //将查询的list存入值栈中
        ActionContext.getContext().getValueStack().set("list", list);
        return "findSuccess";
    }

    /**
     * 跳转添加页面方法
     *
     * @return
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 保存客户的方法
     */
    public String save() {
        //接受数据
        //封装数据
        //调用业务层
        CustomerService customerService = new CustomerServiceImpl();
        customerService.save(customer);
        return "saveSuccess";
    }
}
