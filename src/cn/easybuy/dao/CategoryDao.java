package cn.easybuy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import cn.easybuy.domain.Category;
import cn.easybuy.domain.Product;
import cn.easybuy.model.ProductCustom;

@Repository
public class CategoryDao {

	@Resource
	private DataSource dataSource;
	@Resource
	private ProductDao productDao;

	/** 得到所有商品分类 */
	public List<Category> getAll() {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product_category";
		try {
			return queryRunner.query(sql, new BeanListHandler<Category>(
					Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 根据分类id查询商品分类 */
	public Category getById(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product_category WHERE categoryId=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Category>(
					Category.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 根据商品分类id查询所有子类分类对象List集合 */
	public List<Category> getChildrenIds(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product_category WHERE parentId=?";
		try {
			return queryRunner.query(sql, new BeanListHandler<Category>(
					Category.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 根据商品分类id查询所有商品及商品分类，最后返回商品包装类List集合 */
	public List<ProductCustom> getByCategoryId(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product_category WHERE parentId=?";
		List<Product> productList = new ArrayList<Product>();
		try {
			List<Category> CategoryList = queryRunner.query(sql,
					new BeanListHandler<Category>(Category.class), id);
			if (CategoryList.size() != 0) { // 当该分类id下还有分类
				for (Category category : CategoryList) {
					productList.addAll(productDao.getByCategoryId(category
							.getCategoryId()));
				}
			} else {
				productList = productDao.getByCategoryId(id); // 根据分类id得到所有商品
			}
			List<ProductCustom> pcList = new ArrayList<ProductCustom>();
			// 申明返回的包装类List集合
			Category category = getById(id); // 根据此id查询分类信息
			for (Product product : productList) {
				ProductCustom pc = new ProductCustom();
				pc.setCategory(category);
				pc.setProduct(product);
				pcList.add(pc); // 将分类信息封装到每个商品中
			}
			return pcList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
