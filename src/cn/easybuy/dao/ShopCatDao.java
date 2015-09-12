package cn.easybuy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.easybuy.domain.Category;
import cn.easybuy.domain.Product;
import cn.easybuy.model.ProductCustom;

@Repository
public class ShopCatDao {

	@Resource
	private DataSource dataSource;
	@Resource
	private ProductDao productDao;
	@Resource
	private CategoryDao categoryDao;

	/** 根据商品id数组来查询商品信息 */
	public List<ProductCustom> getProductCustomByIds(List<Integer> ids) {
		List<ProductCustom> pcList = new ArrayList<ProductCustom>();
		for (Integer id : ids) {
			ProductCustom pc = new ProductCustom(); // 包装类
			Product product = productDao.getById(id); // 通过id查询商品
			Category category = categoryDao.getById(product.getCategoryId()); // 商品类别
			pc.setProduct(product); // 将商品信息设置到包装类中
			pc.setCategory(category); // 将商品类别设置到商品包装类中
			pcList.add(pc);
		}
		return pcList;
	}
}
