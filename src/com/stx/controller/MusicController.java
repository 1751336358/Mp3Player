package com.stx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stx.pojo.Music;
import com.stx.pojo.Say;
import com.stx.pojo.Type;
import com.stx.service.MusicService;
import com.stx.service.SayService;


//标记一个Controller
@Controller("musicrController")
public class MusicController {
	Log logger = LogFactory.getLog(MusicController.class);
	//查看我的音乐，根据userid
	@RequestMapping("/SelMusicByUserId")
	public ModelAndView SelMusicByUserId(HttpServletRequest request){
		
		String userid = request.getParameter("userid");
		
		List<Music> musicList= musicService.SelMusicByUserId(userid);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("musicList", musicList);
		modelAndView.setViewName("/WEB-INF/jsp/MyMusic.jsp");
		return modelAndView;
	}
	
	//跳转到音乐详情页面,所有页面查看详情都通过这个方法
	@RequestMapping("/Detail")
	public ModelAndView Detail(Music music) throws Exception{
		music.setFilename(new String(music.getFilename().getBytes("iso8859-1"),"utf-8"));				
		List<Say> listSay = sayService.SelAllSay(music.getId());		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("music", music);
		modelAndView.addObject("listSay",listSay);
		modelAndView.setViewName("/WEB-INF/jsp/Detail.jsp");
		return modelAndView;
	}
	
	//跳转到SingnameMusic.jsp
	@RequestMapping("/SingnameMusic/{singname}")
	public String SingnameMusic(@PathVariable("singname") String singname,Model model) throws Exception{
		singname = new String(singname.getBytes("iso8859-1"),"utf-8");
		
		List<Music> musicList = musicService.SelMusicBySingname(singname);
		
		model.addAttribute("musicList",musicList);
		return "/WEB-INF/jsp/SingnameMusic.jsp";
	}
	
	//根据typeid查询music
	@RequestMapping("/TypeMusic/{typeid}")
	public String TypeMusic(@PathVariable("typeid") int typeid,Model model){
		
		List<Music> musicList = musicService.SelMusicByTypeid(typeid);
		
		model.addAttribute("musicList", musicList);
		return "/WEB-INF/jsp/TypeMusic.jsp";
	}
	
	//查询出所有的typeid和typename
	@RequestMapping("/SelAllType")
	public @ResponseBody List<Type> SelAllType(){
		List<Type> listType = musicService.SelAllType();
		return listType;
	}
	@Resource(name="musicService")
	private MusicService musicService;
	@Resource(name="sayService")
	private SayService sayService;
}
