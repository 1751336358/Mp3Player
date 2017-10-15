package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;


public interface ManagerMapper {
	//管理员添加音乐分类
	public void addType(String typename);
	//查看数据库是否有该分类
	public int SelTypeByTypename(String typename);
	
	//查询出所有歌手
	public List<String> SelAllSingName();

}
