package cn.contentcl.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.contentcl.dao.CustomerDao;
import cn.contentcl.domain.Customer;
import cn.contentcl.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> find() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		tx.commit();
		return list;
	}
	
}
