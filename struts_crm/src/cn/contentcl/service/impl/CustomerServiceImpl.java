package cn.contentcl.service.impl;

import java.util.List;

import cn.contentcl.dao.CustomerDao;
import cn.contentcl.dao.impl.CustomerDaoImpl;
import cn.contentcl.domain.Customer;
import cn.contentcl.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> find() { 
		// 调用dao
		CustomerDao customerDao = new CustomerDaoImpl();

		return customerDao.find();
	}

}
