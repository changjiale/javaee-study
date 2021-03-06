package live.leer.spring.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib动态代理
 *
 * @author leer
 */
public class CglibProxy implements MethodInterceptor {

    private CustomerDao customerDao;

    public CglibProxy(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    /**
     * 使用cglib产生代理的方法
     */
    public CustomerDao createProxy() {

        //创建cglib的核心类对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(customerDao.getClass());
        //设置回调 （类似InvocationHandle的invoke）
        enhancer.setCallback(this);
        //创建代理对象
        CustomerDao proxy = (CustomerDao) enhancer.create();
        return proxy;
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy methodProxy) throws Throwable {
        // TODO Auto-generated method stub
        //判断方法是否为save
        if ("save".equals(method.getName())) {
            System.out.println("权限校验@@@@@@@");
            return methodProxy.invokeSuper(proxy, arg2);
        }
        return methodProxy.invokeSuper(proxy, arg2);
    }
}
