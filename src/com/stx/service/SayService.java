package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.pojo.Say;

public interface SayService {
	
	//将用户评论插入数据库
	public Say addSay(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	//查看所有评论，根据musicid
	public List<Say> SelAllSay(String musicid);
	
	//删除评论，根据say.id
	public void delSayById(String id);
	
}