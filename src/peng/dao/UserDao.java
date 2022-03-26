package peng.dao;

import peng.bean.User;

public interface UserDao {

	/**
	 * �����û������ѯ��ϸ��Ϣ
	 * @param user
	 * @return
	 */
	public User getUserByUserNameAndPassword(User user);
	
	/**
	 * �Ǽ��û���Ϣ�����ݿ�
	 * @param user
	 * @return
	 */
	public boolean registUser(User user);
	
	/**
	 * getUserByUserName for username-reuse-or-not validation
	 * @param user
	 * @return
	 */
	public User getUserByUserName(User user);
	
}
