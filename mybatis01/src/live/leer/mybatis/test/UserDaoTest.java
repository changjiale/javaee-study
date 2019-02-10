package live.leer.mybatis.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import live.leer.mybatis.dao.UserDao;
import live.leer.mybatis.dao.impl.UserDaoImpl;
import live.leer.mybatis.pojo.User;

public class UserDaoTest {

	@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserById(30);
		System.out.println(user);
	}

	@Test
	public void testGetUserByUserName() {
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.getUserByUserName("张");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUsername("张飞3");
		user.setAddress("深圳市黑马");
		user.setBirthday(new Date());
		user.setSex("1");
		userDao.insertUser(user);
	}


}
