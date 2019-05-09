package cloud.consumer.web;


import cloud.consumer.client.UserClient;
import cloud.consumer.pojo.User;
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
//熔断返回函数
//@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController{
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RibbonLoadBalancerClient client;
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }
//    @GetMapping("{id}")
//    //开启熔断的处理
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
//    public String queryById(@PathVariable("id") Long id) {
//        if(id%2==0){
//            throw new RuntimeException("");
//        }
//        String url = "http://user-service/user/"+id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
    public String queryByIdFallBack() {
        return "服务拥挤";
    }
    /*@GetMapping("{id}")
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
    }*/
}