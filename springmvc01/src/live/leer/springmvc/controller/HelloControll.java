package live.leer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControll {
	
	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("hello*******");
		ModelAndView mav = new ModelAndView();
		//设置模型数据，用于传递到jsp
		mav.addObject("msg","hello,mvc");
		//设置视图名字，用于响应用户
		mav.setViewName("/WEB-INF/jsp/hello.jsp");
		
		return mav;
	}
}
