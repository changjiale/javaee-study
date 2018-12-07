package cn.contentcl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * hibernate 测试
 */
public class HibernateDemo {
	
	@Test
	public void demo1(){
		//1加载Hibernate的核心配置文件
		Configuration configuration = new Configuration().configure();
		//2创建一个SessionFactory,类似于JDBC中的连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//3通过sessionFactory获取到Session对象，类似于JDBC中的Connection
		Session session = sessionFactory.openSession();
		//4手动开启事务
		Transaction transaction = session.beginTransaction();
		//5手动编写代码
		Customer customer = new Customer();
		customer.setCust_name("测试");
		
		session.save(customer);	
		//6事务提交
		transaction.commit();
		//7资源释放
		session.close();
	}
}
