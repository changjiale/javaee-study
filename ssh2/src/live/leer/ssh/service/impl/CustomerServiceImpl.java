package live.leer.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import live.leer.ssh.dao.CustomerDao;
import live.leer.ssh.domain.Customer;
import live.leer.ssh.service.CustomerService;

/**
 * 客户管理业务层实现类
 * @author leer
 *
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

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		// TODO Auto-generated method stub
		return customerDao.findById(cust_id);
	}

	@Override
	public List<Customer> findAllByHQL() {
		// TODO Auto-generated method stub
		return customerDao.findAllByHQL();
	}

	@Override
	public List<Customer> findAllByQBC() {
		// TODO Auto-generated method stub
		return customerDao.findAllByQBC();
	}

	@Override
	public List<Customer> findAllByNamedQuery() {
		// TODO Auto-generated method stub
		return customerDao.findAllByNamedQuery();
	}

}

