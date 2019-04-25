package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.Pojo.User;
import springboot.service.UserService;

@RestController
@RequestMapping("user")
public class HelloController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("{id}")
    public User selectById(@PathVariable("id") Long id){
        return userService.queryById(id); 
    }
}
