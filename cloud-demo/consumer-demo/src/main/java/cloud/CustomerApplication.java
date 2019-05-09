package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//服务熔断
@EnableCircuitBreaker
//客户端注册中心
@EnableDiscoveryClient
@SpringBootApplication

//或三合一
//@SpringCloudApplication
//启动feign实现负载均衡远程调用代码隐藏
@EnableFeignClients
public class CustomerApplication {
    @Bean
    //负载均衡
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
