package cn.easybuy.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetLastInsertId {

	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DataSource dataSource = (DataSource) ac.getBean("dataSource");
		String sql = "INSERT INTO t_user(username, password) values('赵四','123')";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(
				sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			System.out.println("插入记录的id：" + rs.getInt(1));
		}
	}
}
