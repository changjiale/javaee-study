package cn.contentcl.struts.demo3;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	public String find() {
		System.out.println("查询商品****");
		return NONE;
	}

	public String update() {
		System.out.println("更新商品****");
		return NONE;
	}

	public String delete() {
		System.out.println("删除商品****");
		return NONE;
	}

	public String save() {
		System.out.println("保存商品****");
		return NONE;
	}

}
