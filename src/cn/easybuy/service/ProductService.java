package cn.easybuy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.ProductDao;
import cn.easybuy.domain.Product;

@Service
public class ProductService {

	@Resource
	private ProductDao productDao;

	/** 根据id查询商品 */
	public Product getById(int id) {
		return productDao.getById(id);
	}

	/** 添加商品 */
	public void add(Product product) {
		productDao.insert(product);
	}

	/** 查询所有商品 */
	public List<Product> queryAll() {
		return productDao.queryAll();
	}

	/** 根据id删除商品 */
	public void delete(int id) {
		productDao.delete(id);
	}

	/** 修改商品 */
	public void edit(Product product) {
		productDao.update(product);
	}

	/** 按照条件查询商品 */
	public List<Product> search(String condition) {
		return productDao.search(condition);
	}

}
