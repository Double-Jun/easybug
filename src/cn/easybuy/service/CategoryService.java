package cn.easybuy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.CategoryDao;
import cn.easybuy.domain.Category;
import cn.easybuy.model.ProductCustom;

@Service
public class CategoryService {

	@Resource
	private CategoryDao categoryDao;

	/** 所有商品分类 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/** 通过商品分类id查询该分类所有商品 */
	public List<ProductCustom> getByCategoryId(int id) {
		return categoryDao.getByCategoryId(id);
	}

}
