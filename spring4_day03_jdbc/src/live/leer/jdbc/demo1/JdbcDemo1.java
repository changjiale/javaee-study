package live.leer.jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Jdbc模板
 * @author leer
 *
 */
public class JdbcDemo1 {

	@Test
	//jdbc模板的使用类似于dbutils
	public void demo1() {
		//创建连接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring4_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		//创建jdbc模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into account values (null,?,?)","张滚西",10000d);
	}
}
