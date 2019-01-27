package live.leer.jdbc.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import live.leer.jdbc.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcDemo2 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void demo1() {
		jdbcTemplate.update("insert into account values (null,?,?)","三十",20000d);
		
	}
	
	@Test
	//更新操作
	public void demo2() {
		jdbcTemplate.update("update account set name=?, money=? where id = ?","去",20000d,1);
	}
	@Test
	public void demo3() {
		jdbcTemplate.update("delete from account where id = ?",5);
	}

	@Test
	// 查询操作：
	public void demo4(){
		String name = jdbcTemplate.queryForObject("select name from account where id = ?", String.class, 4);
		System.out.println(name);
	}
	
	@Test
	// 统计查询
	public void demo5(){
		Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
		System.out.println(count);
	}
	
	@Test
	// 封装到一个对象中
	public void demo6(){
		Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 5);
		System.out.println(account);
	}
	
	@Test
	// 查询多条记录
	public void demo7(){
		List<Account> list = jdbcTemplate.query("select * from account", new MyRowMapper());
		for (Account account : list) {
			System.out.println(account);
		}
	}
	
	class MyRowMapper implements RowMapper<Account>{

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getDouble("money"));
			return account;
		}
		
	}

}
