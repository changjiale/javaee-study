package live.leer.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import live.leer.springmvc.pojo.Item;
import live.leer.springmvc.pojo.QueryVo;
import live.leer.springmvc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("itemList")
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
	@RequestMapping("updateItem")
	public String updateItem(Item item,Model model){
		itemService.updateItem(item);
		model.addAttribute("item", item);
		model.addAttribute("msg", "修改商品信息成功");
		return "itemEdit";
	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo,Model model){
		if(vo.getItem() != null){
			System.out.println(vo.getItem());
		}
		
		//模拟搜索商品
		List<Item> itemList = itemService.getItemList();

		model.addAttribute("itemList", itemList);
		return "itemList";
	}
}
