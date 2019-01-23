package live.leer.service.impl;

import live.leer.dao.CustomerDao;
import live.leer.domain.Customer;
import live.leer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("save方法执行了");
		customerDao.save(customer);
	}

}
