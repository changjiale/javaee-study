package pagehelper.mapper;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import pagehelper.service.UserService;
import pagehelper.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<Brand> {

    //分页查询方法
    @Select("select * from tb_brand")
    public List<Brand> findAll() throws Exception;



}