package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.MusicDao;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotSingname;
import com.stx.service.MusicService;

//标记一个Service
@Service("musicService")
public class MusicServiceImpl implements MusicService {
	//查询music.filename，根据music.id
	public  String SelMusicNameByMusicId(String id){
		return musicDao.SelMusicNameByMusicId(id);
	}
	//查询我的音乐，根据userid
	public List<Music> SelMusicByUserId(String userid) {
		// TODO Auto-generated method stub
		return musicDao.SelMusicByUserId(userid);
	}
	
	// 热门歌手，根据歌手的唱歌的数量查询歌曲的数量和歌手,前十名
	public List<HotSingname> SelSingCountBySingname(){
		return musicDao.SelSingCountBySingname();
	}
	
	//根据歌手名把该歌手唱的所有音乐查询出来
	public List<Music> SelMusicBySingname(String singname){
		return musicDao.SelMusicBySingname(singname);
	}
	
	//根据typeid把所有音乐查出来
	public List<Music> SelMusicByTypeid(int typeid){
		return musicDao.SelMusicByTypeid(typeid);
	}
	
	//查询出所有的typeid和typename
	public List<Type> SelAllType(){
		return musicDao.SelAllType();
	}
	@Resource(name="musicDao")
	private MusicDao musicDao;//注入
	
}
