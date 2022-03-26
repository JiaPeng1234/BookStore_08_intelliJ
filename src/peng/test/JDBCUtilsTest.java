package peng.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import peng.utils.JDBCUtils;

public class JDBCUtilsTest {
	@Test
	public void getConnection() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		JDBCUtils.releaseConnection();
	}
}
