package live.leer.ssh.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import live.leer.ssh.dao.CustomerDao;
import live.leer.ssh.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("DAO的save方法执行了");
		this.getHibernateTemplate().save(customer);
	}

}
