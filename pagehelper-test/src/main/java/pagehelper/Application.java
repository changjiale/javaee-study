package pagehelper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("pagehelper.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
