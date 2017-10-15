package com.stx.dao;

import java.util.List;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;

public interface IndexDao {
	//��ѯ��������
	public List<Music> AllMusic();
	
	////����type.id����ѯ��������
	public List<Music> HotMusic(int typeid);
	
	//�鿴���еķ����type.id
	public List<Type> SelTypeId();
	
	//���ݹؼ���key��ѯ
	public List<Music> SelByKey(String key);
	
	//��ѯ�Ȳ�mv������playnum
	public List<HotMV> SelHotMv();
}
