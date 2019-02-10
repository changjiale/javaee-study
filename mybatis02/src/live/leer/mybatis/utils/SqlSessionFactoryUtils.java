package live.leer.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			//创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//创建核心输入流
			InputStream inputStream =  Resources.getResourceAsStream("SqlMapConfig.xml");
			//通过输入流创建sqlsessionfactory对象
			sqlSessionFactory =  sessionFactoryBuilder.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取sqlsessionFactory
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
	
}
