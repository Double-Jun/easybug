package cn.easybuy.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.easybuy.domain.User;
import cn.easybuy.model.OrderCustom;
import cn.easybuy.service.OrderService;

/**
 * 订单Controller类
 * 
 * @author mingjun chen
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	/** 查看我的订单*/
	public String showOrder(Map<String, Object> map, HttpSession session){
		User user = (User) session.getAttribute("user");
		List<OrderCustom> orderList = orderService.getOrder(user.getUserId());
		map.put("orderList", orderList);
		return "orderList";
	}

	/** 确认订单，同时填写送货信息,跳转到支付页面 */
	@RequestMapping("/verify")
	public String verify(OrderCustom orderCustom) {
		return "success";
	}

	/** 下订单 */
	@RequestMapping("/place")
	public String place(HttpServletRequest request, OrderCustom orderCustom) {
		System.out.println("before:" + orderCustom.getProductCustomList());
		User user = (User) request.getSession().getAttribute("user");
		// 得到登陆的用户信息
		if (user != null) {
			orderCustom.setUser(user); // 关联用户信息
			orderCustom = orderService.save(orderCustom); // 保存订单
			request.setAttribute("orderCustom", orderCustom);
			return "orderVerify";
		} else {
			return "redirect:../user/loginUI";
		}
	}
}
