package cn.contentcl.struts2.demo2;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import cn.contentcl.struts2.domain.User;

/**
 * 数据封装的方式一： 提供属性的set方法的方式
 * @author leer
 *
 */
public class UserAction1 extends ActionSupport {
	//提供了对应属性
	private String usename;
	private String password;
	private Integer age;
	private Date birthday;
	private Double salary;
	
	//提供对象的set方法
	public void setUsename(String usename) {
		this.usename = usename;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

	@Override
	public String execute() throws Exception {
		//封装数据
		User user = new User();
		user.setAge(age);
		user.setBirthday(birthday);
		user.setPassword(password);
		user.setSalary(salary);
		user.setUsename(usename);
		return INPUT;
	}
}
