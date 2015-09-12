package cn.easybuy.model;

import java.util.List;

import cn.easybuy.domain.Order;
import cn.easybuy.domain.User;

/**
 * 订单包装类：封装了User信息，Product信息，Order信息
 * 
 * @author mingjun chen
 *
 */
public class OrderCustom {

	private Order order; // 订单
	private User user; // 订单所属用户
	private List<ProductCustom> ProductCustomList; // 一个订单可以有多件商品

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductCustom> getProductCustomList() {
		return ProductCustomList;
	}

	public void setProductCustomList(List<ProductCustom> productCustomList) {
		ProductCustomList = productCustomList;
	}

}
