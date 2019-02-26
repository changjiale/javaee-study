package live.leer.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import live.leer.service.CustomerService;

public class CustomerServiceTest {

    @Test
    public void tt() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
        CustomerService customerService = (CustomerService) ac.getBean("customerService");
        System.out.println(customerService.findAll().size());
    }
}
