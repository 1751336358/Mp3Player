package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.MusicDao;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotSingname;
import com.stx.service.MusicService;

//���һ��Service
@Service("musicService")
public class MusicServiceImpl implements MusicService {
	//��ѯmusic.filename������music.id
	public  String SelMusicNameByMusicId(String id){
		return musicDao.SelMusicNameByMusicId(id);
	}
	//��ѯ�ҵ����֣�����userid
	public List<Music> SelMusicByUserId(String userid) {
		// TODO Auto-generated method stub
		return musicDao.SelMusicByUserId(userid);
	}
	
	// ���Ÿ��֣����ݸ��ֵĳ����������ѯ�����������͸���,ǰʮ��
	public List<HotSingname> SelSingCountBySingname(){
		return musicDao.SelSingCountBySingname();
	}
	
	//���ݸ������Ѹø��ֳ����������ֲ�ѯ����
	public List<Music> SelMusicBySingname(String singname){
		return musicDao.SelMusicBySingname(singname);
	}
	
	//����typeid���������ֲ����
	public List<Music> SelMusicByTypeid(int typeid){
		return musicDao.SelMusicByTypeid(typeid);
	}
	
	//��ѯ�����е�typeid��typename
	public List<Type> SelAllType(){
		return musicDao.SelAllType();
	}
	@Resource(name="musicDao")
	private MusicDao musicDao;//ע��
	
}
