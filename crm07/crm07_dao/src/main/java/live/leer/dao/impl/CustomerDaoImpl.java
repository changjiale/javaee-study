package live.leer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import live.leer.dao.CustomerDao;
import live.leer.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	public List<Customer> findAll(){
		return (List<Customer>)getHibernateTemplate().find("from Customer");
	}
}
