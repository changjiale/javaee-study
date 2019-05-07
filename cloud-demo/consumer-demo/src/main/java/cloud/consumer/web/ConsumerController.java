package cloud.consumer.web;


import cloud.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController{
    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RibbonLoadBalancerClient client;


    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
//        //根据服务id获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从实例中取出ip和端口
//        ServiceInstance instance = instances.get(0);
//        ServiceInstance instance = client.choose("user-service");
        //随机， 轮询， hash，最小访问
        String url = "http://user-service/user/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}