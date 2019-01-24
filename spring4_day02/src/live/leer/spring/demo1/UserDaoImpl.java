package live.leer.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户DAO的实现类
 * @author leer
 *
 */

@Component("userDao")  //相当于<bean id="userDao" class="xxxxx">
public class UserDaoImpl implements UserDao {
	
	private String name;
	
	@Value("王东")
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("DAO中保存用户的方法执行..."+name);
	}

}
