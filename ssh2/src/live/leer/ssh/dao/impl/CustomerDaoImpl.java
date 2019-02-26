package live.leer.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import live.leer.ssh.dao.CustomerDao;
import live.leer.ssh.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void save(Customer customer) {
        System.out.println("DAO中的save方法执行了...");
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public void update(Customer customer) {
        // TODO Auto-generated method stub
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public void delete(Customer customer) {
        // TODO Auto-generated method stub
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public Customer findById(Long cust_id) {
        // TODO Auto-generated method stub
        return this.getHibernateTemplate().get(Customer.class, cust_id);
    }

    @Override
    public List<Customer> findAllByHQL() {
        // TODO Auto-generated method stub
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
        return list;
    }

    @Override
    public List<Customer> findAllByQBC() {
        // TODO Auto-generated method stub
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);

        return list;
    }

    @Override
    public List<Customer> findAllByNamedQuery() {
        // TODO Auto-generated method stub
        return (List<Customer>) this.getHibernateTemplate().findByNamedQuery("queryAll");
    }


}
