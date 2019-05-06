package cloud.consumer.web;


import cloud.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController{
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        String url = "http://localhost:8081/user/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}