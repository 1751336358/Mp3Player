package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.User;
import com.stx.pojo.pack.HotSingname;

public interface MusicService {
	//��ѯmusic.filename������music.id
	public  String SelMusicNameByMusicId(String id);
	
	//��ѯ�ҵ����֣�����userid
	public List<Music> SelMusicByUserId(String userid);
	
	// ���Ÿ��֣����ݸ��ֵĳ����������ѯ�����������͸���,ǰʮ��
	public List<HotSingname> SelSingCountBySingname();
	
	//���ݸ������Ѹø��ֳ����������ֲ�ѯ����
	public List<Music> SelMusicBySingname(String singname);
	
	//����typeid���������ֲ����
	public List<Music> SelMusicByTypeid(int typeid);
	
	//��ѯ�����е�typeid��typename
	public List<Type> SelAllType();
}