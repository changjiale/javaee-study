package cn.contentcl.struts.demo1;
/**
 * struts2的入门Action类
 * @author leer
 *
 */
public class HelloAction {
	/**
	 * 提供一个方法
	 * * 方法签名固定
	 * 共有的返回值是String类型 方法名execute 在这个方法中不能传递参数
	 */
	public String execute() {
		System.out.println("HelloAction执行了....s");
		return "success";
	}

}
