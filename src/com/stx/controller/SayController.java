package com.stx.controller;



import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.pojo.Say;
import com.stx.service.SayService;


//标记一个Controller
@Controller("sayController")
public class SayController {
	

	//将用户的评论插入数据库
	@RequestMapping("/addSay")
	public void addSay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Say say = sayService.addSay(request, response);
		JSONObject json = JSONObject.fromObject(say);
		System.out.println(json.toString());
		response.getWriter().print(json.toString());
	}
	
	//删除评论，根据say.id
	@RequestMapping("/delSayById")
	public void delSayById(String id,HttpServletResponse response){
		sayService.delSayById(id);
		try {
			response.getWriter().print("0");
		} catch (IOException e) {
			
		}
	}
	
	@Resource(name="sayService")
	private SayService sayService;
}
