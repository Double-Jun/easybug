package cn.easybuy.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import cn.easybuy.domain.Product;
import cn.easybuy.model.OrderCustom;
import cn.easybuy.model.ProductCustom;
import cn.itcast.jdbc.JdbcUtils;

@Repository
public class OrderDao {

	@Resource
	private DataSource dataSource;
	@Resource
	private ProductDao productDao;

	/** 保存订单，同时返回该订单显示给用户 */
	public OrderCustom insert(OrderCustom orderCustom) {
		// 1.先插入订单Order表
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "INSERT INTO t_order(createTime, totalCost, status, userId)"
				+ " values(?,?,?,?)";
		String sql2 = "SELECT LAST_INSERT_ID()";
		double totalCost = 0.0D; // 计算订单总价，double类型
		for (int i = 0; i < orderCustom.getProductCustomList().size(); i++) {
			ProductCustom pc = (ProductCustom) orderCustom
					.getProductCustomList().toArray()[i];
			if (pc.getProduct() != null) { // 这里判断商品是否为null是因为提交的时候把购物车中没有选中的商品全部提交过来了，这里后期可以优化
				Product product = productDao.getById(pc.getProduct()
						.getProductId()); // 根据商品id查询该商品信息，因为下面要用到商品的价格
				pc.setProduct(product); // 将商品信息设置到包装类中，后面插入订单明细表时要用到
				totalCost += product.getPrice() * pc.getNumber();
			} else {
				orderCustom.getProductCustomList().remove(i);
				i--;
			}
		}
		try {
			JdbcUtils.beginTransaction(); // 开启事务
			queryRunner.update(sql, new Date(), totalCost, 0, orderCustom
					.getUser().getUserId());
			int id = (int) queryRunner.query(sql2, new ScalarHandler());
			// 2.插入订单详细表，即让订单表和商品表关联起来
			insertOrderDetail(orderCustom, id);
			JdbcUtils.commitTransaction(); // 提交事务
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction(); // 回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return orderCustom;
	}

	/** 添加订单表和商品表的关系 */
	public void insertOrderDetail(OrderCustom orderCustom, int orderId) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "INSERT INTO t_order_detail(number, cost, orderId, productId) "
				+ "VALUES(?,?,?,?)";
		for (ProductCustom pc : orderCustom.getProductCustomList()) {
			if (pc.getProduct() != null && orderId != 0) { // 根据商品和订单id插入订单明细
				try {
					queryRunner.update(sql, pc.getNumber(), pc.getProduct()
							.getPrice(), orderId, pc.getProduct()
							.getProductId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 查询我的订单 @param id */
	public List<OrderCustom> getOrderByUserId(int id) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_order, t_order_detail WHERE t_order.";
		
		return null;
	}
}
