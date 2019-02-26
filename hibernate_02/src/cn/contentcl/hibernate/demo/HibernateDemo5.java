package cn.contentcl.hibernate.demo;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * Hibernate其他API
 *
 * @author leer
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

    @Test
    //Criteria
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //通过session来获取Criteria 的对象
		/*Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();*/

        //条件查询
		/*Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cust_name", "王%"));*/

        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(2);
        List<Customer> list = criteria.list();


        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }

}
