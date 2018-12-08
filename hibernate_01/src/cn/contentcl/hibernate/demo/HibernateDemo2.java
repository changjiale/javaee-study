package cn.contentcl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * Hibernate 的工具类测试
 * @author leer
 *
 */


public class HibernateDemo2 {
	
	@Test
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("李四");
		session.save(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/**
		 * get方法
		 * * 采用立即加载，执行到这行代码的时候，就会马上发送SQL语句
		 * * 查询后返回的是真是对象本身
		 * *查询一个找不到的对象的时，返回null
		 * 
		 * 
		 * load方法
		 * *采用的是延迟加载（lazy懒加载），执行这行代码的时候，不会发送SQL语句，当真正使用这个对象的时候才会发送sql语句
		 * *查询后返回的是代理对象，javassist-3.18.1-GA.jar 利用javassist技术产生的代理
		 * *查询一个找不到的对象的时候，返回ObjectNotFoundException
		 */
		/*//使用get方法查询
		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);*/
		
		//使用load方法查询
		Customer customer = session.load(Customer.class, 2l);
		System.out.println(customer);
		
		
		tx.commit();
		session.close();
	}
	

}
