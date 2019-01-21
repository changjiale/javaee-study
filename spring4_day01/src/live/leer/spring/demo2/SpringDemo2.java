package live.leer.spring.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import live.leer.spring.demo1.UserDAO;

public class SpringDemo2 {

	@Test
	/**
	 * 生命周期配置
	 */
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDAO customerDAO = (CustomerDAO) applicationContext.getBean("customerDAO");
		customerDAO.save();
		applicationContext.close();
		applicationContext.close();
	}
	
	@Test
	/**
	 * Bean的作用范围配置
	 */
	public void demo2(){
		ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDAO customerDAO1 = (CustomerDAO) applicationContext.getBean("customerDAO");
		System.out.println(customerDAO1);
		CustomerDAO customerDAO2 = (CustomerDAO) applicationContext.getBean("customerDAO");
		System.out.println(customerDAO2);
		System.out.println(customerDAO1==customerDAO2);
		applicationContext.close();
	}
}
