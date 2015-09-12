package cn.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import cn.easybuy.domain.Product;

@Repository
public class ProductDao {

	@Resource
	private DataSource dataSource;

	/** 根据商品分类id查询商品 */
	public List<Product> getByCategoryId(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product WHERE categoryId=?";
		try {
			return queryRunner.query(sql, new BeanListHandler<Product>(
					Product.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据商品分类查询对应商品 public List<ProductCustom>
	 * getProductByCategoryId(List<Category> categories) throws SQLException {
	 * QueryRunner queryRunner = new QueryRunner(dataSource); String sql =
	 * "SELECT * FROM t_product WHERE categoryId=?"; List<ProductCustom> pcList
	 * = new ArrayList<ProductCustom>(); for (Category category : categories) {
	 * List<Product> products = queryRunner.query(sql, new
	 * BeanListHandler<Product>(Product.class), category.getCategoryId()); for
	 * (Product product : products) { ProductCustom category2 = new
	 * ProductCustom(); category2.setProduct(product);
	 * category2.setCategory(category); pcList.add(category2); } } return
	 * pcList; }
	 * */

	/** 根据id查询商品 */
	public Product getById(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product WHERE productId=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Product>(
					Product.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 商品修改 */
	public void update(Product product) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "UPDATE t_product SET name=?, description=?,price=?,"
				+ " stock=?,img=?,categoryId=?  WHERE productId = ?";
		try {
			queryRunner.update(sql, product.getName(),
					product.getDescription(), product.getPrice(),
					product.getStock(), product.getImg(),
					product.getCategoryId(), product.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 商品添加 */
	public void insert(Product p) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "INSERT INTO t_product"
				+ "(name,description,price,stock,img,categoryId)"
				+ " VALUES(?,?,?,?,?,?) ";
		Object[] params = { p.getName(), p.getDescription(), p.getPrice(),
				p.getStock(), p.getImg(), p.getCategoryId() };
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 查询所有商品 */
	public List<Product> queryAll() {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product";
		try {
			return queryRunner.query(sql, new BeanListHandler<Product>(
					Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 根据id删除商品 */
	public void delete(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "DELETE FROM t_product WHERE productId=?";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 根据查询条件查询商品，采用like模糊查询 */
	public List<Product> search(String condition) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_product WHERE name like ?";
		try {
			return queryRunner.query(sql, new BeanListHandler<Product>(
					Product.class), "%" + condition + "%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
