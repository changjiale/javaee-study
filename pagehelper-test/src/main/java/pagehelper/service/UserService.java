package pagehelper.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagehelper.mapper.UserMapper;
import pagehelper.pojo.Brand;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<Brand> findAll() throws Exception {
        //分页查询：查询第一页，每页10行。
        PageHelper.startPage(2, 5);
        List<Brand> users =userMapper.findAll();
        return users;
    }

}