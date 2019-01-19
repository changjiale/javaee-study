package cn.contentcl.service.impl;

import cn.contentcl.dao.UserDao;
import cn.contentcl.dao.impl.UserDaoImpl;
import cn.contentcl.domain.User;
import cn.contentcl.service.UserService;

/**
 * 用户业务层实现类
 * @author leer
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	// 业务层用户登录的方法:
	public User login(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}

	

}
