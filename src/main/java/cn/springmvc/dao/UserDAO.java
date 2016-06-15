package cn.springmvc.dao;

import cn.springmvc.model.User;


public interface UserDAO {

	/**
	 * ������û�
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	public void updateUser(User user);
	
	public User selectUser(int id);
	
	
}