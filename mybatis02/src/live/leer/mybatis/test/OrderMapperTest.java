package live.leer.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import live.leer.mybatis.mapper.OrderMapper;
import live.leer.mybatis.pojo.Order;
import live.leer.mybatis.utils.SqlSessionFactoryUtils;

public class OrderMapperTest {

    @Test
    public void TestGetOrderList() {

        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 获取代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.getOrderList();
        for (Order order : list) {
            System.out.println(order);
        }
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void TestGetOrderListMap() {

        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 获取代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.getOrderListMap();
        for (Order order : list) {
            System.out.println(order);
        }
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void TestGetOrderUser2() {

        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 获取代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.getOrderUser2();
        for (Order order : list) {
            System.out.println(order);
            System.out.println("此订单的用户为： " + order.getUser());
        }
        // 关闭资源
        sqlSession.close();
    }

}
