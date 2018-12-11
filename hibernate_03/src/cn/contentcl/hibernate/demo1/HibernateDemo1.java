package cn.contentcl.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import cn.contentcl.hibernate.domain.Customer;
import cn.contentcl.hibernate.domain.LinkMan;
import cn.contentcl.hibernate.utils.HibernateUtils;
/**
 * 一对多的测试类
 * @author leer
 *
 */

public class HibernateDemo1 {
	
	@Test
	/**
	 * 保存2个客户和三个联系人并建立好关系
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("11");
		
		//创建2个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王东");
		Customer customer2 = new Customer();
		customer2.setCust_name("黄冲");
		
		//创建三个联系人 
		LinkMan linkman1 = new LinkMan();
		linkman1.setLkm_name("小李");
		LinkMan linkman2 = new LinkMan();
		linkman2.setLkm_name("小张");
		LinkMan linkman3 = new LinkMan();
		linkman3.setLkm_name("小帅");
		
		//建立关系
		linkman1.setCustomer(customer1);
		linkman2.setCustomer(customer1);
		linkman3.setCustomer(customer2);
		
		customer1.getLinkMans().add(linkman1);
		customer1.getLinkMans().add(linkman2);
		customer2.getLinkMans().add(linkman3);
		
		session.save(linkman1);
		session.save(linkman2);
		session.save(linkman3);
		session.save(customer1);
		session.save(customer2);
		
		tx.commit();
		
		
	}

}
