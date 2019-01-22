package live.leer.spring.demo3;
/**
 * Bean2的静态工厂
 * @author jt
 *
 */
public class Bean2Factory {

	public static Bean2 createBean2(){
		System.out.println("Bean2Factory中方法执行了...");
		return new Bean2();
	}
}
