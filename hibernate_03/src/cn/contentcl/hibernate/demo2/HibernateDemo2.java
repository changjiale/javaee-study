package cn.contentcl.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.contentcl.hibernate.domain.Role;
import cn.contentcl.hibernate.domain.User;
import cn.contentcl.hibernate.utils.HibernateUtils;

public class HibernateDemo2 {
	
	@Test
	/**
	 * 保存多条记录，保存多个用户和角色
	 */
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建2个用户
		User user1 = new User();
		user1.setUser_name("张宏");
		User user2 = new User();
		user2.setUser_name("李冰");
		
		//创建三个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		Role role2 = new Role();
		role2.setRole_name("市场部");
		Role role3 = new Role();
		role3.setRole_name("公关部");
		
		//设置双向的关系
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		
		//保存操作 ，多对多建立和双向的关系必须有一方放弃外键维护
		//一般是被动方放弃外键维护权
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);
		
		tx.commit();
		
		
		
		
	}
	
	
	@Test
	/**
	 * 多对多的操作：
	 * * 只保存一边是否可以？ 不可以，瞬时异常
	 */
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建2个用户
		User user1 = new User();
		user1.setUser_name("张宏");
		
		//创建三个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		
		//设置双向的关系
		user1.getRoles().add(role1);
		
		role1.getUsers().add(user1);
		
		//只保存用户
		session.save(user1);
		
		tx.commit();
		
		
		
		
	}
	
	@Test
	/**
	 * 多对多的级联操作
	 * 保存用户级联保存角色.在用户映射文件配置
	 */
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建2个用户
		User user1 = new User();
		user1.setUser_name("张宏");
		
		//创建三个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		
		//设置双向的关系
		user1.getRoles().add(role1);
		
		role1.getUsers().add(user1);
		
		//只保存用户
		session.save(user1);
		
		tx.commit();
		

		
	}
	
	/**
	 * 多对多的级联删除
	 * 删除用户级联 删除对象
	 * 在User.hbm.xml中的set上配置cascade="delete"
	 */
	@Test
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		//查询1号用户
		User user = session.get(User.class, 1l);
		session.delete(user);
		tx.commit();
		
		
	}
	
	/**
	 * 多对多的级联删除
	 * 删除角色级联 删除用户
	 * 在Role.hbm.xml中的set上配置cascade="delete"
	 */
	@Test
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		
		//查询2号角色
		Role role = session.get(Role.class, 2l);
		session.delete(role);
		tx.commit();
		
		
	}
	
	/**
	 * 给用户选择角色
	 */
	@Test
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//给1号用户多选2号角色
		//查询1号用户
		User user = session.get(User.class, 1l);
		//查询2号角色
		Role role = session.get(Role.class, 2l);
		user.getRoles().add(role);
		
		tx.commit();
		
		
	}
	
	/**
	 * 给用户改选角色
	 */
	@Test
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//给2号用户 将原有3号角色改为1号角色
		//查询2号用户
		User user = session.get(User.class, 2l);
		//查询1，3号角色
		Role role1 = session.get(Role.class, 1l);
		Role role3 = session.get(Role.class, 3l);
		user.getRoles().remove(role3);
		user.getRoles().add(role1);
		
		tx.commit();
		
		
	}

}
