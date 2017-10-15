package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.MusicDao;
import com.stx.mapper.MusicMapper;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotSingname;

@Repository("musicDao")
public class MusicDaoImpl extends  SqlSessionDaoSupport implements MusicDao {
	
	//��ѯmusic.filename������music.id
	public  String SelMusicNameByMusicId(String id){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicNameByMusicId(id);
	}
	//��ѯ�ҵ����֣�����userid
	public List<Music> SelMusicByUserId(String userid) {
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicByUserId(userid);
	}
	
	// ���Ÿ��֣����ݸ��ֵĳ����������ѯ�����������͸���,ǰʮ��
	public List<HotSingname> SelSingCountBySingname(){
		return this.getSqlSession().getMapper(MusicMapper.class).SelSingCountBySingname();
	}
	
	//���ݸ������Ѹø��ֳ����������ֲ�ѯ����
	public List<Music> SelMusicBySingname(String singname){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicBySingname(singname);
	}
	
	//����typeid���������ֲ����
	public List<Music> SelMusicByTypeid(int typeid){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicByTypeid(typeid);
	}
	
	//��ѯ�����е�typeid��typename
	public List<Type> SelAllType(){
		return this.getSqlSession().getMapper(MusicMapper.class).SelAllType();
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
}
