package cloud.user.service;

import cloud.user.mapper.UserMapper;
import cloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
