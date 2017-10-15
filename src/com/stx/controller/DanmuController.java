package com.stx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;
import com.stx.service.DanmuService;


//���һ��Controller
@Controller("danmuController")
public class DanmuController {
	
	//�������ֵ�Ļ,RESTful
	@RequestMapping("/SendDanmu/{time}/{musicid}/{detail}")
	public @ResponseBody void SendDanmu(@PathVariable("time") int time,@PathVariable("musicid") String musicid,@PathVariable("detail") String detail,HttpServletResponse response){

		try {
			detail = new String(detail.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		Danmu danmu = new Danmu(time,musicid,detail);
		danmuService.SendDanmu(danmu);
		try {
			response.getWriter().print("0");
		} catch (IOException e) {
			
		}
	}
	

	//��ѯ���ֵ�Ļ������musicid��time
	@RequestMapping("/SelDanmu/{musicid}/{time}")
	public @ResponseBody List<DanmuMessage> SelDanmu(@PathVariable("musicid") String musicid,@PathVariable("time") int time,HttpServletResponse response) throws IOException{
		Danmu danmu = new Danmu();
		danmu.setMusicid(musicid);
		danmu.setTime(time);	
		List<DanmuMessage> danmuList = danmuService.SelDanmu(danmu);
		return danmuList;
	}
	
	//����MV��Ļ
	@RequestMapping("/SendMVDanmu/{time}/{videoid}/{detail}")
	public @ResponseBody void SendMVDanmu(@PathVariable("time") int time,@PathVariable("videoid") String videoid,@PathVariable("detail") String detail,HttpServletResponse response){
		
		try {
			detail = new String(detail.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			
		}
	
		//��mv��Ļ����mvdanmu��
		MVDanmu mvDanmu = new MVDanmu(time,videoid,detail);
		danmuService.SendMVDanmu(mvDanmu);
		
		try {
			response.getWriter().print("0");
		} catch (IOException e) {
			
		}
		
	}
	
	//��ѯMV��Ļ������id��time
	@RequestMapping("/SelMVDanmu/{videoid}/{time}")
	public @ResponseBody List<DanmuMessage> SelMVDanmu(@PathVariable("videoid") String videoid,@PathVariable("time") int time){
		MVDanmu mvDanmu = new MVDanmu();
		mvDanmu.setTime(time);
		mvDanmu.setMvid(videoid);
		return danmuService.SelMVDanmu(mvDanmu);
	}
	@Resource(name="danmuService")
	private DanmuService danmuService;
}
