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


//���һ��Controller
@Controller("sayController")
public class SayController {
	

	//���û������۲������ݿ�
	@RequestMapping("/addSay")
	public void addSay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Say say = sayService.addSay(request, response);
		JSONObject json = JSONObject.fromObject(say);
		System.out.println(json.toString());
		response.getWriter().print(json.toString());
	}
	
	//ɾ�����ۣ�����say.id
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
