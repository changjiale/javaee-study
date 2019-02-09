package live.leer.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import live.leer.mybatis.pojo.User;
import live.leer.mybatis.utils.SqlSessionFactoryUtils;

public class MybatisTest {

	@Test
	public void testGetUserById() throws IOException {
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//创建核心输入流
		InputStream inputStream =  Resources.getResourceAsStream("SqlMapConfig.xml");
		//通过输入流创建sqlsessionfactory对象
		SqlSessionFactory sqlSessionFactory =  sessionFactoryBuilder.build(inputStream);
		//创建sqlsession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		User user = sqlSession.selectOne("user.getUserById",1);
		 System.out.println(user);
		 
		 //释放资源
		 sqlSession.close();
	}
	
	@Test
	public void testGetUserByName() {
		//获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("user.getUserByName", "张");
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		 sqlSession.close();
		
		
	}
	@Test
	public void testInsertUser() {
		//获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("张飞3");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("白马寺");
		sqlSession.insert("user.insertUser", user);
		System.out.println(user);
		//提交事务
		sqlSession.commit();
		//释放资源
		 sqlSession.close();
		
		
	}
}
