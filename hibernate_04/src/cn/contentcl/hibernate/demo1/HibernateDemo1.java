package cn.contentcl.hibernate.demo1;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.domain.Customer;
import cn.contentcl.hibernate.domain.LinkMan;
import cn.contentcl.hibernate.utils.HibernateUtils;

public class HibernateDemo1 {

    @Test
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //创建一个客户
        Customer customer = new Customer();
        customer.setCust_name("李祥文");

        for (int i = 1; i <= 10; i++) {
            LinkMan linkman = new LinkMan();
            linkman.setLkm_name("上" + i);
            linkman.setCustomer(customer);

            customer.getLinkMans().add(linkman);
            session.save(linkman);
        }
        session.save(customer);

        tx.commit();

    }

    @Test
    /**
     * HQL的简单查询
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //简单的查询
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        //sql中文支持*的写法：select * from cst_customer; 但在HQL中不支持*的写法
        //Query query = session.createQuery("select * from Customer"); 报错
        //List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }

    @Test
    /**
     * HQL的别名查询
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //别名
        Query query = session.createQuery("select c from Customer c");
        List<Customer> list = query.list();


        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }


    @Test
    /**
     * HQL的排序查询
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //排序查询
        //默认情况
        //Query query = session.createQuery("from Customer order by cust_id");
        //设置降序 升序使用asc 降序使用desc
        Query query = session.createQuery("from Customer order by cust_id desc");

        List<Customer> list = query.list();


        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }


    @Test
    /**
     * HQL的条件查询
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //条件的查询
        //一： 按位置查询
        //一个条件
		/*Query query = session.createQuery("from Customer where cust_name=?");
		query.setParameter(0, "李冰");
		List<Customer> list = query.list();*/
        //多个条件
		/*Query query = session.createQuery("from Customer where cust_name like ? and cust_source= ?");
		query.setParameter(0, "李%");
		query.setParameter(1, "小广告");
		List<Customer> list = query.list();*/

        //按名称绑定
        Query query = session.createQuery("from Customer where cust_name like :bbb and cust_source= :aaa");
        query.setParameter("aaa", "朋友推荐");
        query.setParameter("bbb", "李%");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }

    @Test
    /**
     * HQL的投影查询
     */
    public void demo6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //投影查询
        //单个属性
		/*Query query = session.createQuery("select c.cust_name from Customer c");
		List<Object> list = query.list();
		for (Object object:list) {
			System.out.println(object); 
		}*/
        //多个属性
		/*Query query = session.createQuery("select c.cust_name, c.cust_source from Customer c");
		List<Object[]> list = query.list();
		for (Object[] objects:list) {
			System.out.println(Arrays.toString(objects)); 
		}*/

        //查询多个属性，但我们封装在对象中
        Query query = session.createQuery("select new Customer(cust_name, cust_source) from Customer");
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();

    }


    @Test
    /**
     * HQL的分页查询
     */
    public void demo7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //分页查询

        Query query = session.createQuery("from LinkMan");
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<LinkMan> list = query.list();
        for (LinkMan linkman : list) {
            System.out.println(linkman);
        }

        tx.commit();

    }

    @Test
    /**
     * HQL的分组统计查询
     */
    public void demo8() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //聚合函数的使用： count(),max(),min,avg().sum
        Query query = session.createQuery("select count(*) from Customer");
        Object object = query.uniqueResult();
        System.out.println(object);

        //分组统计
        List<Object[]> list = session.createQuery("select cust_source,count(*) from Customer group by cust_source").list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
        tx.commit();

    }

    @Test
    /**
     * HQL的多表查询
     */
    public void demo9() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //SQL: select * from cst_customer c inner join cst_linkman l on c.cust_id=l.lkm_cust_id;
        //HQL： 内连接from Customer c inner join c.linkMans
		/*List<Object[]> list = session.createQuery("from Customer c inner join c.linkMans").list();
		for (Object[] objects: list) {
			System.out.println(Arrays.toString(objects));
		}*/

        // HQL:迫切内连接 其实就在普通的内连接inner join后添加一个关键字fetch. from Customer c inner
        // join fetch c.linkMans
        List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans")
                .list();// 通知hibernate，将另一个对象的数据封装到该对象中

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();

    }

}
