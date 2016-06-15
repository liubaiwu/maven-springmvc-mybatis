package cn.springmvc.dao;

import cn.springmvc.model.User;


public interface UserDAO {

	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	public void updateUser(User user);
	
	public User selectUser(int id);
	
	
}