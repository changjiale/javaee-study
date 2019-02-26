package live.leer.spring.demo1;

import org.junit.Test;

public class SpringDemo1 {

    @Test
    //jdk动态代理
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        //创建代理
        UserDao proxy = new JdkProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.find();
        proxy.delete();
    }
}
