package cn.easybuy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.easybuy.model.ProductCustom;
import cn.easybuy.service.ShopCatService;
import cn.easybuy.utils.CookieUtils;

/**
 * 商品购物车
 * 
 * @author mingjun chen
 *
 */
@Controller
@RequestMapping("/cart")
public class ShopCartController {

	@Resource
	private ShopCatService shopCatService;

	/** 清空购物车 */
	@RequestMapping("/empty")
	public String empty(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			try {
				Integer.parseInt(cookie.getName());
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie); // 通知客户端
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return "redirect:show";
	}

	/** 根据id删除购物车商品 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		System.out.println("要删除cookie的值为：" + id);
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(String.valueOf(id))) {
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "redirect:../show";
	}

	/** 修改购物车中指定商品的数量 +1 */
	@RequestMapping("/plus/{id}")
	public String puls(@PathVariable(value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		CookieUtils.plus(Integer.parseInt(id), request, response);
		return "redirect:../show";
	}

	/** 修改购物车中指定商品的数量 -1 */
	@RequestMapping("/reduce/{id}")
	public String reduce(@PathVariable(value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		CookieUtils.reduce(Integer.parseInt(id), request, response);
		return "redirect:../show";
	}

	/** 将商品添加到购物车（实际就是将商品id设置到浏览器的cookie中） */
	@RequestMapping("/add/{id}")
	public String add(@PathVariable(value = "id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		CookieUtils.plus(id, request, response); // 添加cookie
		return "redirect:/product/queryAll";
	}

	/** 查看购物车 */
	@RequestMapping("/show")
	public ModelAndView show(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies(); // 取得所有cookie
		Map<Integer, Integer> idMap = new HashMap<Integer, Integer>(); // 保存cookie中商品id，最后要从数据库查询
		List<Integer> ids = new ArrayList<Integer>();
		for (Cookie cookie : cookies) {
			try {
				System.out.println("key:" + cookie.getName() + "value:"
						+ cookie.getValue());
				// 注意：这里有一个cookie不是自己添加的，他不能转为int类型，所有需要使用异常判断来进行剔除
				idMap.put(Integer.parseInt(cookie.getName()),
						Integer.parseInt(cookie.getValue()));
				ids.add(Integer.parseInt(cookie.getName()));
			} catch (NumberFormatException e) {
				continue;
			}
		}
		List<ProductCustom> pcList = shopCatService.show(ids);
		// 将cookie中取得的商品数量设置到包装类中
		for (int j = 0; j < pcList.size(); j++) {
			for (Integer i : idMap.keySet()) {
				if (pcList.get(j).getProduct().getProductId() == i) {
					pcList.get(j).setNumber(idMap.get(i));
				}
			}
		}
		return new ModelAndView("cart", "pcList", pcList);
	}
}
