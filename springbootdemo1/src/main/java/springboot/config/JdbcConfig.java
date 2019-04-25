package springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
//@PropertySource("classpath:application.properties")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;

//    @Bean
//    public DataSource dataSource(JdbcProperties prop){
//        DruidDataSource dataSource =  new DruidDataSource();
//        dataSource.setDriverClassName(prop.getDriverClassName());
//        dataSource.setUrl(prop.getUrl());
//        dataSource.setUsername(prop.getUsername());
//        dataSource.setPassword(prop.getPassword());
//        return dataSource;
//    }
//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource(){
//        DruidDataSource dataSource =  new DruidDataSource();
//
//        return dataSource;
//    }
}
