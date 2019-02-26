package cn.contentcl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.contentcl.dao.UserDao;
import cn.contentcl.domain.User;
import cn.contentcl.utils.HibernateUtils;

/**
 * UserDao 实现类
 *
 * @author leer
 */
public class UserDaoImpl implements UserDao {

    @Override
    // 用户的DAO的登录的方法:
    public User login(User user) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from User where user_code=? and user_password=?");
        // 设置参数:
        query.setParameter(0, user.getUser_code());
        query.setParameter(1, user.getUser_password());
        List<User> list = query.list();
        if (list.size() > 0) {
            return list.get(0);
        }

        tx.commit();
        return null;
    }

}
