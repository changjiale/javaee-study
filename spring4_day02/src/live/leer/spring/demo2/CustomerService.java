package live.leer.spring.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")
@Scope("prototype")
public class CustomerService {

    @PostConstruct //相当于init-method
    public void init() {
        System.out.println("CustomerService被创建了");
    }

    public void save() {
        System.out.println("CustomerService的save方法被执行了");
    }

    @PreDestroy //相当于destroy-method
    public void destroy() {
        System.out.println("CustomerService被销毁了");
    }
}
