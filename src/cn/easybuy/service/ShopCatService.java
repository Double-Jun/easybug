package cn.easybuy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.ShopCatDao;
import cn.easybuy.model.ProductCustom;

/**
 * 购物车查询
 * 
 * @author mingjun chen
 *
 */
@Service
public class ShopCatService {

	@Resource
	private ShopCatDao shopcatDao;

	/** 根据商品id数组来查询商品 */
	public List<ProductCustom> show(List<Integer> ids) {
		return shopcatDao.getProductCustomByIds(ids);
	}

}
