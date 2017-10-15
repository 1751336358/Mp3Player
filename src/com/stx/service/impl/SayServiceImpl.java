package com.stx.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.stx.dao.SayDao;
import com.stx.pojo.Say;
import com.stx.service.SayService;
import com.stx.util.TimeFormat;

//标记一个Service
@Service("sayService")
public class SayServiceImpl implements SayService {
	
	
	
	//将用户评论插入数据库
	public Say addSay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String musicid = request.getParameter("musicid");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String detail = request.getParameter("detail");
		System.out.println("musicid="+musicid);
		System.out.println("userid="+userid);
		System.out.println("username="+username);
		System.out.println("detail="+detail);
		
		Say say = new Say();
		say.setMusicid(musicid);
		say.setUserid(userid);
		say.setUsername(username);
		say.setDetail(detail);
		say.setId(UUID.randomUUID().toString());
		say.setTime(TimeFormat.getLocalTime());
		sayDao.addSay(say);
		return say;
	}
	
	
	//查看所有评论，根据musicid
	public List<Say> SelAllSay(String musicid){
		return sayDao.SelAllSay(musicid);
	}
	
	//删除评论，根据say.id
	public void delSayById(String id){
		sayDao.delSayById(id);
	}
	@Resource(name="sayDao")
	private SayDao sayDao;//注入
	
	
	
}
