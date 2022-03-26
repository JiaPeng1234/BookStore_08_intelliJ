package peng.dao;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import peng.utils.JDBCUtils;

public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	private Class<T> type; //��⣺Class<T>��һ������ʱ�࣬Ҳ����Class��һ��ʵ����Ҳ����ָT��������౾��
	
	public BaseDao() {
		// TODO Auto-generated constructor stub
		// ��ȡ��������ͣ�����ʱ�����Ͳ����� ParameterizedType ������� ���������࣬Ҳ���Ƿ�����
		
		//UserDao�����Ĵ����͵ĸ���
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
//		System.out.println(superclass.getClass());
		
		//UserDao�����Ĵ����͵ĸ��࣬���������ķ�����ʲô�ࣿ��Ҳ������Class<T>������T��
		type = (Class<T>) superclass.getActualTypeArguments()[0];
	}

	/**
	 * ��ȡһ������
	 * 
	 * @return
	 */
	public T getBean(String sql, Object...params){
		Connection connection = JDBCUtils.getConnection();
		T query = null;
		try {
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("BaseDao exception occurs");
		} 
//		finally {
//			JDBCUtils.releaseConnection(connection);
//		}
		return query;
	}

	/**
	 * ��ȡ����ļ���
	 * 
	 * @return
	 */
	
	public List<T> getBeanList(String sql, Object...params){
		Connection connection = JDBCUtils.getConnection();
		List<T> query = null;
		try {
			query = runner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			throw new RuntimeException("BaseDao exception occurs");
		} 
//		finally {
//			JDBCUtils.releaseConnection(connection);
//		}
		return query;
	}

	/**
	 * ִ����ɾ��
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object...params){
		//
		int count = 0;
		Connection connection = JDBCUtils.getConnection();
		try {
			count = runner.update(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			throw new RuntimeException("BaseDao exception occurs");
		} 
//		finally {
//			JDBCUtils.releaseConnection(connection);
//		}
		return count;
	}
	
	/**
	 * BaseDao���ص���ֵ�ķ���, BookDao�л��õ�
	 * @return
	 */
	public Object getSingleValue(String sql, Object...params){
		Object query = null;
		Connection connection = JDBCUtils.getConnection();
		try {
			query = runner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			throw new RuntimeException("BaseDao exception occurs");
		} 
//		finally {
//			JDBCUtils.releaseConnection(connection);
//		}
		return query;
	}
	
	/**
	 * ��������batch����ÿһ��sqlִ��֮���ٹر����ӣ�������һ��һ��
	 * @param sql
	 * @param params
	 * @return
	 */
	public int batch(String sql, Object[][] params){
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException("BaseDao exception occurs");
		} 
//		finally {
//			JDBCUtils.releaseConnection(connection);
//		}
		return 1;
	}
}
