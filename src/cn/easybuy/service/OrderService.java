package cn.easybuy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.OrderDao;
import cn.easybuy.model.OrderCustom;

@Service
public class OrderService {

	@Resource
	private OrderDao orderDao;

	public OrderCustom save(OrderCustom orderCustom) {
		return orderDao.insert(orderCustom);
	}

	public List<OrderCustom> getOrder(int id) {
		return orderDao.getOrderByUserId(id);
	}

}
