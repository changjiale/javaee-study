package cn.contentcl.hibernate.demo2;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.domain.Customer;
import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * Hibernate的延迟加载
 * @author leer
 *
 */

public class HibernateDemo1 {
	
	/**
	 * 类级别的延迟加载
	 * * 在<class>的标签上配置的lazy
	 */
	@Test
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.load(Customer.class, 1l);
		System.out.println(customer);
		
		tx.commit();
		
	}
}
