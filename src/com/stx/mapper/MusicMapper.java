package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotSingname;


public interface MusicMapper {
	//查询music.filename，根据music.id
	public  String SelMusicNameByMusicId(String id);
	//查询我的音乐，根据userid
	public List<Music> SelMusicByUserId(String userid);
	
	// 热门歌手，根据歌手的唱歌的数量查询歌曲的数量和歌手,前十名
	public List<HotSingname> SelSingCountBySingname();
	
	//根据歌手名把该歌手唱的所有音乐查询出来
	public List<Music> SelMusicBySingname(String singname);
	
	//根据typeid把所有音乐查出来
	public List<Music> SelMusicByTypeid(int typeid);
	
	//查询出所有的typeid和typename
	public List<Type> SelAllType();
}
