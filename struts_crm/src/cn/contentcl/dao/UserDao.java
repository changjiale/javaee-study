package cn.contentcl.dao;

import cn.contentcl.domain.User;

/**
 * 用户的DAO接口
 *
 * @author leer
 */
public interface UserDao {

    User login(User user);

}
