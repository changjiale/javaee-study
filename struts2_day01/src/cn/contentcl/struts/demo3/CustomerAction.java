package cn.contentcl.struts.demo3;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{
	public String find() {
		System.out.println("查询客户****");
		return NONE;
	}

	public String update() {
		System.out.println("更新客户****");
		return NONE;
	}

	public String delete() {
		System.out.println("删除客户****");
		return NONE;
	}

	public String save() {
		System.out.println("保存客户****");
		return NONE;
	}

}
