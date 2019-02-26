package cn.contentcl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * Hibernate的一级缓存
 *
 * @author leer
 */
public class HibernateDemo3 {

    @Test
    //证明一级缓存
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer1 = session.get(Customer.class, 1l);//发送sql
        System.out.println(customer1);

        Customer customer2 = session.get(Customer.class, 1l);//不发送sql  从缓存中查找
        System.out.println(customer2);

        System.out.println(customer1 == customer2);

        tx.commit();
        session.close();


    }

    @Test
    //一级缓存清空
    public void demo3() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer1 = session.get(Customer.class, 1l);//发送sql

        /*
         * session.clear();//清空所有
         * session.evict(customer1); //清除单个对象
         */

        Customer customer2 = session.get(Customer.class, 1l);//不发送sql  从缓存中查找
        System.out.println(customer2);


        tx.commit();
        session.close();


    }

}
