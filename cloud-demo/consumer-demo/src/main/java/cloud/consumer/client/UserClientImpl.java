package cloud.consumer.client;

import cloud.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("未查询到用户");
        return user;
    }
}
