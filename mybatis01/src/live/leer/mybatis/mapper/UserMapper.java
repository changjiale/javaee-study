package live.leer.mybatis.mapper;

import java.util.List;

import live.leer.mybatis.pojo.User;

public interface UserMapper {

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 根据用户名查找用户列表
     *
     * @param name
     * @return
     */
    List<User> getUserByUserName(String name);

    /**
     * 添加用户
     *
     * @param user
     */
    void insertUser(User user);
}

