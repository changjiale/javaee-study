package cn.contentcl.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import cn.contentcl.hibernate.domain.Customer;
import cn.contentcl.hibernate.domain.LinkMan;
import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * 一对多的测试类
 *
 * @author leer
 */

public class HibernateDemo1 {

    @Test
    /**
     * 保存2个客户和三个联系人并建立好关系
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

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

    @Test
    /**
     * 一对多只保存一边
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("赵洪");

        LinkMan linkman = new LinkMan();
        linkman.setLkm_name("如花");
        customer.getLinkMans().add(linkman);
        linkman.setCustomer(customer);

        //只保存一边是否可以，不可以，报一个瞬时对象异常，持久态对象关联一个顺势态对象

        session.save(customer);
        //session.save(linkman);


        tx.commit();


    }

    @Test
    /**
     * 级联保存或更新操作
     * 保存客户级联联系人，操作的主体是客户对象，需要在Customer.hibernate.xml中进行配置
     * <set name="linkMans" cascade="save-update">
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("赵洪");

        LinkMan linkman = new LinkMan();
        linkman.setLkm_name("如花");
        customer.getLinkMans().add(linkman);
        linkman.setCustomer(customer);

        session.save(customer);


        tx.commit();


    }

    @Test
    /**
     * 级联保存或更新操作
     * 保存联系人级联客户，操作的主体是联系人对象，需要在LinkMan.hibernate.xml中进行配置
     * <many-to-one name="customer"  cascade="save-update" class="cn.contentcl.hibernate.domain.Customer" column="lkm_cust_id"></many-to-one>
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("赵s四");

        LinkMan linkman = new LinkMan();
        linkman.setLkm_name("王五");
        customer.getLinkMans().add(linkman);
        linkman.setCustomer(customer);

        session.save(linkman);


        tx.commit();


    }

    @Test
    /**
     *测试对象导航
     *前提： 一对多的双方都设置了  cascade=“save-update”
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("李冰");

        LinkMan linkman1 = new LinkMan();
        linkman1.setLkm_name("芙蓉");
        LinkMan linkman2 = new LinkMan();
        linkman2.setLkm_name("如花");
        LinkMan linkman3 = new LinkMan();
        linkman3.setLkm_name("芙蓉");

        linkman1.setCustomer(customer);
        customer.getLinkMans().add(linkman2);
        customer.getLinkMans().add(linkman3);


        //双方都设置了cascade
        //session.save(linkman1); //发送4条insert语句  linkman1+customer+linkman2+linman3
        //session.save(customer); //发送三条insert语句  customer+linkman2+linkman3
        session.save(linkman2);//发送1条insert语句

        tx.commit();

    }

    @Test
    /**
     *级联删除：
     *删除客户级联删除联系人,删除的主体是客户，需要在Customer.hbm.xml中配置
     *<set name="linkMans" cascade="delete">
     */
    public void demo6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //没有设置级联删除，默认情况：修改了联系人的外键，删除客户
		/*Customer customer = session.get(Customer.class, 1l);
		session.delete(customer);*/

        //删除客户同时删除联系人
        Customer customer = session.get(Customer.class, 1l);
        session.delete(customer);

        tx.commit();

    }

    @Test
    /**
     *级联删除：
     *删除联系人级联删除客户,删除的主体是客户，需要在LinkMan.hbm.xml中配置
     *<many-to-one name="customer"  cascade="save-update,delete"....
     */
    public void demo7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();


        //删除联系人同时删除客户
        LinkMan linkman = session.get(LinkMan.class, 3l);
        session.delete(linkman);

        tx.commit();

    }

    @Test
    /**
     *将2号联系人原本来归一号客户，现在改为2号客户
     */
    public void demo8() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //查询2号联系人
        LinkMan linkman = session.get(LinkMan.class, 2l);
        //查询2号客户
        Customer customer = session.get(Customer.class, 2l);

        //双向的关联   但导致两次update数据，配置文件配置inverse=“true” 放弃夺得一方的外键维护权
        linkman.setCustomer(customer);
        customer.getLinkMans().add(linkman);
        tx.commit();

    }

    @Test
    /**
     * 区分cascade和inverse的区别
     */
    public void demo9() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("李冰");

        LinkMan linkman = new LinkMan();
        linkman.setLkm_name("凤姐");

        customer.getLinkMans().add(linkman);

        //条件在Customer.hbm.xml上的set中配置了cascade="save-update" inverse="true"
        session.save(customer); //客户会插入到数据库，联系人也会插入到数据库，但外键为null  --》放弃外键维护


        tx.commit();

    }

}
