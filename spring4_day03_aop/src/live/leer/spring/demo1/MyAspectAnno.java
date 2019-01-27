package live.leer.spring.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类：注解的切面类
 * @author leer
 *
 */
@Aspect
public class MyAspectAnno {
	@Before(value="execution(* live.leer.spring.demo1.OrderDao.save(..))")
	public void before() {
		System.out.println("前置增强===============");
	}
	
	@AfterReturning(value="execution(* live.leer.spring.demo1.OrderDao.delete(..))",returning="result" )
	public void afterReturning(Object result) {
		System.out.println("后置增强=============="+result);
	}
	//环绕
	@Around(value="execution(* live.leer.spring.demo1.OrderDao.find(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕前=========");
		Object object = joinPoint.proceed();
		System.out.println("环绕后==========");
		return object;
	}
	//异常抛出
	@AfterThrowing(value="execution(* live.leer.spring.demo1.OrderDao.update(..))",throwing="e")
	public void afterThrowing(Throwable e) {
		System.out.println("异常抛出=========="+e.getMessage());
	}
	
	//最终通知
	@After(value="MyAspectAnno.pointcut1()")
	public void after() {
		System.out.println("最终增强==============");
	}
	
	@Pointcut(value="execution(* live.leer.spring.demo1.OrderDao.save(..))")
	private void pointcut1() {}
}
