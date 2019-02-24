package live.leer.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import live.leer.springmvc.exception.MyException;
import live.leer.springmvc.pojo.Item;
import live.leer.springmvc.pojo.QueryVo;
import live.leer.springmvc.service.ItemService;

@Controller
//@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value={"itemList","itemList2"})
	public ModelAndView itemList() {
		ModelAndView mav = new ModelAndView();

		List<Item> itemList = itemService.getItemList();

		mav.addObject("itemList", itemList);
		// mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		mav.setViewName("itemList");
		return mav;
	}

	/**
	 * 跟据ID查询商品信息，跳转修改商品页面
	 * 演示默认支持的参数传递
	 * Model/ModelMap返回数据模型
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	/*@RequestMapping("itemEdit")
	public String itemEdit(Model model,ModelMap modelMap,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String idStr = request.getParameter("id");
		System.out.println("response:" + response);
		System.out.println("session:" + session);
		// 查询商品信息
		Item item = itemService.getItemById(new Integer(idStr));
		//model返回数据模型
		model.addAttribute("item", item);
		//mav.addObject("item", item);
		return "itemEdit";
	}*/
	
	@RequestMapping("itemEdit")
	public String itemEdit(Model model,@RequestParam(value="id",required=true,defaultValue="1") Integer ids) {
		// 查询商品信息
		Item item = itemService.getItemById(ids);
		//model返回数据模型
		model.addAttribute("item", item);
		//mav.addObject("item", item);
		return "itemEdit";
	}
	
	/**
	 * 修改商品 
	 * 演示pojo参数绑定
	 * @param item
	 * @return
	 */
	@RequestMapping(value="updateItem",method={RequestMethod.POST,RequestMethod.GET})
	public String updateItem(Item item,Model model){
		itemService.updateItem(item);
		model.addAttribute("item", item);
		model.addAttribute("msg", "修改商品信息成功");
		return "itemEdit";
	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo,Integer[] ids,  Model model){
		if(vo.getItem() != null){
			System.out.println(vo.getItem());
		}
		if (ids!=null && ids.length>0) {
			for (Integer id : ids) {
				System.out.println(id);
			}
		}
		if (vo.getItems() != null && vo.getItems().size() > 0) {
			for (Item item : vo.getItems()) {
				System.out.println(item);
			}
		}
		
		//模拟搜索商品
		List<Item> itemList = itemService.getItemList();

		model.addAttribute("itemList", itemList);
		return "itemList"; 
	}
	
	@RequestMapping("queryVoid")
	public void queryVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MyException {
		
		//request相应用户请求
		/*request.setAttribute("msg", "request相应的消息");
		request.getRequestDispatcher("/WEB-INF/jsp/msg.jsp").forward(request, response);*/
		//response响应用户请求
		/*response.sendRedirect("itemList.action");*/
		
		//假设这里是根据id查询商品信息，搜素不到商品
		if(true) {
			throw new MyException("你查找的商品不存在");
		}
		int i =1/0;
		//设置响应头字符编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("这是一个response打印的消息");
	}
}
