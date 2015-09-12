package cn.easybuy.dao;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import cn.easybuy.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

@Repository
public class UserDao {

	@Resource
	private DataSource dataSource;

	/** 用户注册，插入用户 */
	public void insert(User user) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "INSERT INTO t_user (username, password,gender,birthday,idCard,email,mobile,address )"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUsername(), user.getPassword(),
				user.getGender(), user.getBirthday(), user.getIdCard(),
				user.getEmail(), user.getMobile(), user.getAddress() };
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 通过id得到用户 */
	public User getById(int id) {
		TxQueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM t_user WHERE id=?";
		try {
			return queryRunner
					.query(sql, new BeanHandler<User>(User.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 用户登录验证 */
	public User verifyUser(String username, String password) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		String sql = "SELECT * FROM t_user WHERE username=? and password=?";
		try {
			return queryRunner.query(sql, new BeanHandler<User>(User.class),
					username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
