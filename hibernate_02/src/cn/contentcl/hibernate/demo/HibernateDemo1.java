package cn.contentcl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

public class HibernateDemo1 {
	
	@Test
	//演示increment
	public void demo1(){

	
		Session session = HibernateUtils.openSession();

		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("陈1");
		
		session.save(customer);	
		//6事务提交
		transaction.commit();
		//7资源释放
		session.close();
	}
	
	@Test
	public void demo2(){

	
		Session session = HibernateUtils.openSession();

		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("陈2");
		
		session.save(customer);	
		//6事务提交
		transaction.commit();
		//7资源释放
		session.close();
	}

}
