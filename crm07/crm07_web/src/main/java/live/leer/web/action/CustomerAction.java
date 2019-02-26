package live.leer.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import live.leer.domain.Customer;
import live.leer.service.CustomerService;

public class CustomerAction {

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String list() {
        List<Customer> list = customerService.findAll();
        ServletActionContext.getContext().put("list", list);
        return "list";
    }
}
