package cn.contentcl.hibernate.demo1;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.domain.Customer;
import cn.contentcl.hibernate.domain.LinkMan;
import cn.contentcl.hibernate.utils.HibernateUtils;

/**
 * sql语句查询
 *
 * @author leer
 */

public class HibernateDemo3 {
    @Test
    /**
     * 分页查询
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
		
		/*SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = sqlQuery.list();
		for (Object[] objects: list) {
			System.out.println(Arrays.toString(objects));
		}*/

        SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
        sqlQuery.addEntity(Customer.class);
        List<Customer> list = sqlQuery.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();

    }


}
