package com.stx.mapper;

import java.util.List;
import com.stx.pojo.User;


public interface UserMapper {
	//����ע����û���ӵ����ݿ�
	public void addUserToDb(User user);
	
	//ע��ʱ�ж��û����Ƿ����
	public int testUserIsRegister(User user);
	
	//����username�鵽user����
	public User selUserByUserName(String username);
	
	//��¼ʱ��֤��¼���û����������Ƿ���ȷ
	public int testUserLogin(User user);

}
