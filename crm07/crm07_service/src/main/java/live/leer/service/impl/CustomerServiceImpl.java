package live.leer.service.impl;

import live.leer.dao.CustomerDao;
import live.leer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
}
