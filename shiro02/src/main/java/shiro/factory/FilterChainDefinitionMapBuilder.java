package shiro.factory;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        map.put("/login.jsp","anon");
        map.put("/** ","authc");

        return map;
    }
}
