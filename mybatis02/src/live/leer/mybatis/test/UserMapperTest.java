package live.leer.mybatis.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import live.leer.mybatis.mapper.UserMapper;
import live.leer.mybatis.pojo.Order;
import live.leer.mybatis.pojo.QueryVo;
import live.leer.mybatis.pojo.User;
import live.leer.mybatis.utils.SqlSessionFactoryUtils;

public class UserMapperTest {

	@Test
	public void testGetUserById() {
		// 加载配置得到SqlSession
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 查询数据
		User user = userMapper.getUserById(30);
		System.out.println(user);
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void testGetUserByUserName() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 查询数据
		List<User> list = userMapper.getUserByUserName("张");
		for (User user : list) {
			System.out.println(user);
		}
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张飞飞");
		user.setAddress("深圳市黑马");
		user.setBirthday(new Date());
		user.setSex("1");
		userMapper.insertUser(user);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}
	@Test
	public void TestGetUserByQueryVo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 查询数据
		QueryVo vo = new QueryVo();
		User user2 = new User();
		user2.setUsername("张");
		vo.setUser(user2);
		
		List<User> list = userMapper.getUserByQueryVo(vo);
		for (User user : list) {
			System.out.println(user);
		}
		// 关闭资源
		sqlSession.close();
	}
	
	@Test
	public void TestGetUserCount() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 查询数据
		QueryVo vo = new QueryVo();
		User user2 = new User();
		user2.setUsername("张");
		vo.setUser(user2);
		
		Integer userCount = userMapper.getUserCount();
		System.out.println("用户总数===="+userCount);
		// 关闭资源
		sqlSession.close();
	}
	
	@Test
	public void TestGetUserByPojo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user2 = new User();
		user2.setUsername("张");
		user2.setSex("1");
		List<User> list = userMapper.getUserByPojo(user2);
		for (User user : list) {
			System.out.println(user);
		}
		// 关闭资源
		sqlSession.close();
	}
	@Test
	public void TestGetUserByIds() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		
		//构建id列表
		vo.setIds(Arrays.asList(1,25,30,35));
		List<User> list = userMapper.getUserByIds(vo);
		for (User user : list) {
			System.out.println(user);
		}
		// 关闭资源
		sqlSession.close();
	}
	@Test
	public void TestGetUserOrder() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.getUserOrder();
		for (User user : list) {
			System.out.println(user);
			for (Order order : user.getOrders()) {
				System.out.println("此用户下的订单"+order);
			}
		}
		// 关闭资源
		sqlSession.close();
	}


}



