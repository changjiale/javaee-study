package cn.contentcl.hibernate.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	
	@Test
	//修改操作
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/*//直接创建对象，进行修改
		Customer  customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("王小儿");
		session.update(customer);*/
		
		//先查询，再修改（推荐）
		Customer  customer = session.get(Customer.class,2l);
		customer.setCust_name("王王");
		session.update(customer);
		tx.commit();
		session.close();
	}
	
	@Test
	//删除操作
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//直接删除对象，删除
		/*Customer customer = new Customer();
		customer.setCust_id(1l);
		session.delete(customer);*/
		
		//先查询在删除（推荐）--级联删除
		Customer customer = session.get(Customer.class, 3l);
		session.delete(customer);
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	//保存或更新
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
//		Customer customer = new Customer();
//		customer.setCust_name("王兰");
//		session.saveOrUpdate(customer);
		
		Customer customer = new Customer();
		customer.setCust_id(5l);
		customer.setCust_name("王x兰");
		session.saveOrUpdate(customer);
		
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	//保存或更新
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//接受HQL：Hibernate Query Language 面向对象的查询语言
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		//接收sql语句
		SQLQuery query1 = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list1 = query1.list();
		for (Object[] objects : list1) {
			System.out.println(Arrays.toString(objects));
		}
		
		tx.commit();
		session.close();
	}
	

}
