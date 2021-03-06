package com.stx.dao;

import com.stx.pojo.User;

public interface UserDao {
	//将用户注册的数据插入数据库
	public void addUserToDb(User user);
	
	//注册时判断用户名是否存在
	public int testUserIsRegister(User user);
	
	//根据username查到user对象
	public User selUserByUserName(String username);
	
	//登录时验证登录的用户名和密码是否正确
	public int testUserLogin(User user);
	
	
}
