package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;


public interface ManagerMapper {
	//����Ա������ַ���
	public void addType(String typename);
	//�鿴���ݿ��Ƿ��и÷���
	public int SelTypeByTypename(String typename);
	
	//��ѯ�����и���
	public List<String> SelAllSingName();

}
