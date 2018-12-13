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

}
