package live.leer.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import live.leer.mybatis.dao.UserDao;
import live.leer.mybatis.pojo.User;
import live.leer.mybatis.utils.SqlSessionFactoryUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(Integer id) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		User user = sqlSession.selectOne("user.getUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByUserName(String name) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		List<User> list = sqlSession.selectList("user.getUserByName", name);
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		sqlSession.insert("user.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

}