package peng.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static DataSource ds = new ComboPooledDataSource("book_devoloper");
	private static Map<Long, Connection> conns = new HashMap<>();
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		long id = Thread.currentThread().getId();
		System.out.println("JDBCUtils thread id: "+id);
		Connection connection = conns.get(id);
		if(connection == null) {
			try {
				connection = ds.getConnection();
				conns.put(id, connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return connection;
	}
	
	/**
	 * �ͷ����ݿ�����
	 * @param connection
	 */
	public static void releaseConnection(){
		long id = Thread.currentThread().getId();
		System.out.println("release thread id: "+id);
		Connection connection = getConnection();
		try {
			if (connection != null) {
				connection.close();
				conns.remove(Thread.currentThread().getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
