package live.leer.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;

import live.leer.ssh.dao.CustomerDao;
import live.leer.ssh.domain.Customer;
import live.leer.ssh.service.CustomerService;

/**
 * 客户管理业务层实现类
 *
 * @author leer
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    // 注入DAO;
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        System.out.println("Service中的save方法执行了...");
        customerDao.save(customer);
    }

}

