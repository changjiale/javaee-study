package live.leer.dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import live.leer.dao.CustomerDao;

public class CustomerTest {

    @Test
    public void tt() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
        System.out.println(customerDao.findAll().size());
    }
}
