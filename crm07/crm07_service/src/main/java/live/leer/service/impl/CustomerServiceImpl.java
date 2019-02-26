package live.leer.service.impl;

import java.util.List;

import live.leer.dao.CustomerDao;
import live.leer.domain.Customer;
import live.leer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

}
