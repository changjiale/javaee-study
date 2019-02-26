package live.leer.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import live.leer.mybatis.dao.UserDao;
import live.leer.mybatis.pojo.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User getUserById(Integer id) {
        SqlSession sqlSession = super.getSqlSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        return user;
    }

    @Override
    public List<User> getUserByUserName(String name) {
        SqlSession sqlSession = super.getSqlSession();
        List<User> list = sqlSession.selectList("user.getUserByUserName", name);
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = super.getSqlSession();
        sqlSession.insert("user.insertUser", user);
    }

}