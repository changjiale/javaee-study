package live.leer.ssh.dao;

import java.util.List;

import live.leer.ssh.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer findById(Long cust_id);
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();
	List<Customer> findAllByNamedQuery();
}
