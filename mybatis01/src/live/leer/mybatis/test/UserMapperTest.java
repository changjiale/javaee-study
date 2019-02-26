package live.leer.mybatis.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import live.leer.mybatis.mapper.UserMapper;
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


}



