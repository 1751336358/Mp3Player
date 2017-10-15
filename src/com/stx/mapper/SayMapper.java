package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Say;


public interface SayMapper {
	//将用户评论插入数据库
	public void addSay(Say say);
	
	//查看所有评论，根据musicid
	public List<Say> SelAllSay(String musicid);
	
	//删除评论，根据say.id
	public void delSayById(String id);

}
