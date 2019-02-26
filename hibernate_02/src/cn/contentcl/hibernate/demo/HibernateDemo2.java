package cn.contentcl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.utils.HibernateUtils;

public class HibernateDemo2 {

    @Test
    //三种状态的区分
    public void demo1() {
        Session session = HibernateUtils.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer(); //瞬时态对象，没有位移的OID，没有被session对象
        customer.setCust_name("王东");

        session.save(customer);  //持久态对象，有唯一标识OID，被session管理

        transaction.commit();
        session.close();
        System.out.println("客户名称" + customer.getCust_name()); //托管态对象，有唯一OID没有被session管理


    }

    @Test
    //持久太对象自动更新数据库
    public void demo2() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //获得持久态对象
        Customer customer = session.get(Customer.class, 1l);
        customer.setCust_name("王2");

        /**
         * 持久态对象可不用update方法更新 修改对象直接映射进数据库
         */


        transaction.commit();
        session.close();


    }

}
