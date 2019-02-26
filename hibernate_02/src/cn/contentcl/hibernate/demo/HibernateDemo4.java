package cn.contentcl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * 测试当前线程绑定的Session
 *
 * @author leer
 */

public class HibernateDemo4 {

    @Test
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("往西");
        session.save(customer);

        tx.commit();
        //session.close();  不需要关闭 自动关闭否则报错
    }

}
