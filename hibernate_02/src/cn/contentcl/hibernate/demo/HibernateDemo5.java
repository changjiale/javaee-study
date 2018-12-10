package cn.contentcl.hibernate.demo;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * 	Hibernate其他API
 * 
 * @author leer
 *
 */

public class HibernateDemo5 {
	
	@Test
	//Query
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//通过Session获得Query接口
		//简单查询
		///String hql = "from Customer";
		//条件查询
		//String hql = "from Customer where cust_name like ?";
		//分页查询
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		//设置条件
		//query.setParameter(0, "王%");
		//设置分页
		query.setFirstResult(2);
		query.setMaxResults(2);
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		
	}

}
