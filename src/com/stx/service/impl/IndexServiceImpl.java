package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.IndexDao;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;
import com.stx.service.IndexService;

//���һ��Service
@Service("indexService")
public class IndexServiceImpl implements IndexService {
	
	//��ѯ��������
	public List<Music> AllMusic(){
		return indexDao.AllMusic();
	}
	
	//����type.id����ѯ��������
	public List<Music> HotMusic(int typeid){
		return indexDao.HotMusic(typeid);
	}
	
	//�鿴���еķ����type.id
	public List<Type> SelTypeId(){
		return indexDao.SelTypeId();
	}
	
	//���ݹؼ���key��ѯ
	public List<Music> SelByKey(String key){
		return indexDao.SelByKey(key);
	}
	
	//��ѯ�Ȳ�mv������playnum
	public List<HotMV> SelHotMv(){
		return indexDao.SelHotMv();
	}
	@Resource(name="indexDao")
	private IndexDao indexDao;//ע��
	
	
	
}
