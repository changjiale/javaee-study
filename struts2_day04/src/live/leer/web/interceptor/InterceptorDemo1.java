package live.leer.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorDemo1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InterceptorDemo1执行了");;
		String obj = invocation.invoke();
		System.out.println("InterceptorDemo1执行结束了");
		return obj;
	}
}
