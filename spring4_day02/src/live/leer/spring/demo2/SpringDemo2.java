package live.leer.spring.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

	
	@Test
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		System.out.println(customerService);
		
		CustomerService customerService1 = (CustomerService) applicationContext.getBean("customerService");
		System.out.println(customerService1);
		applicationContext.close();
	}
}
