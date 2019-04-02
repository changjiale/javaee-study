package shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;

import java.util.Date;

public class ShiroService {

    @RequiresRoles({"admin"})
    public void testMethd(){
        System.out.println("testMethod, time"+ new Date());
    }
}
