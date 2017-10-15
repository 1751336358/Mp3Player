package com.stx.mapper;

import java.util.List;
import com.stx.pojo.User;


public interface UserMapper {
	//将新注册的用户添加到数据库
	public void addUserToDb(User user);
	
	//注册时判断用户名是否存在
	public int testUserIsRegister(User user);
	
	//根据username查到user对象
	public User selUserByUserName(String username);
	
	//登录时验证登录的用户名和密码是否正确
	public int testUserLogin(User user);

}
