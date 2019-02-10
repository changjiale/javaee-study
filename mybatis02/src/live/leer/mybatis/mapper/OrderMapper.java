package live.leer.mybatis.mapper;

import java.util.List;

import live.leer.mybatis.pojo.Order;

/**
 * 订单持久化接口
 * @author leer
 *
 */
public interface OrderMapper {
	
	/**
	 * 获取订单列表
	 * @return
	 */
	List<Order> getOrderList();
	
	/**
	 * resultmap使用
	 * @return
	 */
	List<Order> getOrderListMap();
	
	
	/**
	 * 一对一关联 resultmap
	 * @return
	 */
	List<Order> getOrderUser2();
}
