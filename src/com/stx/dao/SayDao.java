package com.stx.dao;

import java.util.List;

import com.stx.pojo.Say;
import com.stx.pojo.User;

public interface SayDao {
	
	//���û����۲������ݿ�
	public void addSay(Say say);
	
	//�鿴�������ۣ�����musicid
	public List<Say> SelAllSay(String musicid);
	
	//ɾ�����ۣ�����say.id
	public void delSayById(String id);
	
}
