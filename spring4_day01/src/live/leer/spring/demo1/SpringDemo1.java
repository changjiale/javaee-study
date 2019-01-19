package live.leer.spring.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * spring的入门
 * @author leer
 *
 */
public class SpringDemo1 {

	@Test
	/**
	 * 传统方式的调用
	 */
	public void demo1(){
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setName("王东");
		userDAO.save();
	}
	
	@Test
	/**
	 * Spring的方式的调用
	 */
	public void demo2(){
		// 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
		userDAO.save();
	}
	
	@Test
	/**
	 * 加载磁盘上的配置文件
	 */
	public void demo3(){
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\applicationContext.xml");
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
		userDAO.save();
	}
}

