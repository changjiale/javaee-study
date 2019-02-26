package cn.contentcl.struts2.demo3;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import cn.contentcl.struts2.domain.Product;

/**
 * 复杂类型封装map的方式
 *
 * @author leer
 */
public class ProductAction2 extends ActionSupport {

    private Map<String, Product> map;


    public Map<String, Product> getMap() {
        return map;
    }


    public void setMap(Map<String, Product> map) {
        this.map = map;
    }


    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        for (String key : map.keySet()) {
            Product product = map.get(key);
            System.out.println(key + " " + product);

        }
        return NONE;
    }
}
