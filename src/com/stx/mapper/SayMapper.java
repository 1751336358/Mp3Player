package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Say;


public interface SayMapper {
	//���û����۲������ݿ�
	public void addSay(Say say);
	
	//�鿴�������ۣ�����musicid
	public List<Say> SelAllSay(String musicid);
	
	//ɾ�����ۣ�����say.id
	public void delSayById(String id);

}
