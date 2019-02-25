package live.leer.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户请求处理器
 * @author leer
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session){
		
		if(username.equals("admin")){
			session.setAttribute("username", username);
			return "redirect:/itemList.action";
		}
		
		return "login";
	}
}

