package cn.contentcl.struts2.demo3;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.contentcl.struts2.domain.Product;

public class ProductAction1 extends ActionSupport {

    private List<Product> products;
    //提供集合的get,set方法


    @Override
    public String execute() throws Exception {
        for (Product product : products) {
            System.out.println(product);
        }
        return NONE;
    }


    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
