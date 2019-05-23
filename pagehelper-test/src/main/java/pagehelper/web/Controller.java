package pagehelper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pagehelper.pojo.Brand;
import pagehelper.service.UserService;

import java.util.List;

@RestController
@RequestMapping("brand")
public class Controller {
    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    public List<Brand> findAll() throws Exception {
        List<Brand> list = userService.findAll();
        return list;
    }

}
