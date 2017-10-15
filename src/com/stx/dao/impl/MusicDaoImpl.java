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
	
	//查询music.filename，根据music.id
	public  String SelMusicNameByMusicId(String id){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicNameByMusicId(id);
	}
	//查询我的音乐，根据userid
	public List<Music> SelMusicByUserId(String userid) {
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicByUserId(userid);
	}
	
	// 热门歌手，根据歌手的唱歌的数量查询歌曲的数量和歌手,前十名
	public List<HotSingname> SelSingCountBySingname(){
		return this.getSqlSession().getMapper(MusicMapper.class).SelSingCountBySingname();
	}
	
	//根据歌手名把该歌手唱的所有音乐查询出来
	public List<Music> SelMusicBySingname(String singname){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicBySingname(singname);
	}
	
	//根据typeid把所有音乐查出来
	public List<Music> SelMusicByTypeid(int typeid){
		return this.getSqlSession().getMapper(MusicMapper.class).SelMusicByTypeid(typeid);
	}
	
	//查询出所有的typeid和typename
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
