package live.leer.spring.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk动态代理对UserDao产生代理
 * @author leer
 *
 */
public class JdkProxy implements InvocationHandler{
	//将被增强的对象传递到代理中
	private UserDao userDao;
	
	public JdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 产生UserDao代理的方法
	 * @return
	 */
	public UserDao createProxy() {
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				userDao.getClass().getInterfaces(), this);
		return userDaoProxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if ("save".equals(method.getName())) {
			System.out.println("权限校验-------------------");
			return method.invoke(userDao, args);
		}
		return method.invoke(userDao, args);
	}
}
