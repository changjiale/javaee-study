package live.leer.mybatis.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import live.leer.mybatis.mapper.UserMapper;
import live.leer.mybatis.pojo.User;

public class UserMapperTest {

private ApplicationContext applicationContext;
	
	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testGetUserById() {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = userMapper.getUserById(10);
		System.out.println(user);
	}


	@Test
	public void testGetUserByUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

}
