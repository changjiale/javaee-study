package live.leer.spring.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 *
 * @author leer
 */
public class MyAspectXML {

    /**
     * 前置通知
     */
    public void checkPri(JoinPoint joinPoint) {
        System.out.println("权限校验**************" + joinPoint);
    }

    /**
     * 后置通知
     */
    public void writeLog(Object result) {
        System.out.println("日志记录—————————————" + result);
    }

    /**
     * 性能监控
     *
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        Object object = joinPoint.proceed();
        System.out.println("环绕后通知");
        return object;
    }

    /**
     * 异常抛出通知
     */
    public void afterThrowing(Throwable ex) {
        System.out.println("异常抛出通知" + ex.getMessage());
    }

    /**
     * 最终通知 相当于finally
     */
    public void after() {
        System.out.println("最终通知");
    }
}


