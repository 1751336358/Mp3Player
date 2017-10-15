package com.stx.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.pojo.pack.MusicMV;
import com.stx.service.MVService;
import com.stx.service.MusicService;


//标记一个Controller
@Controller("mvController")
public class MVController {
	
	
	@RequestMapping("/gotoPlayMV/{musicid}")
	public String gotoPlayMV(@PathVariable("musicid") String musicid,Model model) throws Exception{
		MusicMV musicMv = mvService.SelMvByMusicId(musicid);
		String filename = musicService.SelMusicNameByMusicId(musicid);	//根据music.id查询出music.filename;		
		model.addAttribute("musicid", musicid);		
		model.addAttribute("filename", filename);			
		if(musicMv == null){	//表示该音乐没有mv
			
			return "/WEB-INF/jsp/PlayMV.jsp";
		}
		//在这里将mv的playnum+1，根据mvid
		mvService.UpdatePlaynumByMvId(musicMv.getMvid());
		model.addAttribute("musicMv", musicMv);
		return "/WEB-INF/jsp/PlayMV.jsp";
	}
	
	@Resource(name="mvService")
	private MVService mvService;
	@Resource(name="musicService")
	private MusicService musicService;
}
