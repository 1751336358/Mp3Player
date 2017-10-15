package com.stx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;
import com.stx.pojo.pack.HotSingname;
import com.stx.pojo.pack.MusicMV;
import com.stx.service.IndexService;
import com.stx.service.MVService;
import com.stx.service.MusicService;


//标记一个Controller
@Controller("indexController")
public class IndexController {
	@RequestMapping("/gotoIndex")
	public ModelAndView gotoIndex(){
		ModelAndView modelAndView = new ModelAndView();
		//热门歌曲
		List<Music> hotMusic = HotMusic(11);	//首页展示时，先查出typeid=11的音乐，爱情
		modelAndView.addObject("hotMusic", hotMusic);
		//热门歌手，根据歌手的唱歌的数量查询歌曲的数量和歌手,前十名
		List<HotSingname> hotSingname = SelSingCountBySingname();
		//查看所有的分类的type.id
		List<Type> types = SelTypeId();
		System.out.println("分类的个数"+types.size());
		//查询热播MV
		List<HotMV> hotMv = indexService.SelHotMv(); 
		System.out.println("热门MV个数："+hotMv.size());
		modelAndView.addObject("hotSingname", hotSingname);
		modelAndView.addObject("types", types);
		modelAndView.addObject("hotMv", hotMv);
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
	
	//查看所有的音乐
	public List<Music> AllMusic(){
		List<Music> listMusic = indexService.AllMusic();
		System.out.println("音乐的个数："+listMusic.size());
	
		return listMusic;
	}
	
	//根据type.id，查询热门下载
	@RequestMapping("/HotMusic/{typeid}")
	public @ResponseBody List<Music> HotMusic(@PathVariable("typeid") int typeid){
		System.out.println("typeid="+typeid);
		
		List<Music> listMusic = indexService.HotMusic(typeid);
		System.out.println("查询到的记录是:"+listMusic.size());
		return listMusic;
	}
	
	// 热门歌手，根据歌手的唱歌的数量查询歌曲的数量和歌手,前十名
	public List<HotSingname> SelSingCountBySingname(){
		return musicService.SelSingCountBySingname();
	}
	
	////查看所有的分类的type.id
	public List<Type> SelTypeId(){
		return indexService.SelTypeId();
	}
	
	//根据关键字搜索
	@RequestMapping("/SelByKey")
	public String SelByKey(String key,Model model){
		List<Music> musicList = indexService.SelByKey(key);
		model.addAttribute("musicList",musicList);
		model.addAttribute("message", key);
		return "/WEB-INF/jsp/ListMusicModel.jsp";
		
	}
	
	//跳转到热播MV的界面
	@RequestMapping("/gotoHotMV/{mvid}")
	public String gotoHotMV(@PathVariable("mvid") String mvid,Model model){
		//将mv的playnum+1
		mvService.UpdatePlaynumByMvId(mvid);
		//根据mvid从mv表查询出mv的信息
		MusicMV musicMV = mvService.SelMusicMVByMvId(mvid);
		model.addAttribute("musicMV", musicMV);
		return "/WEB-INF/jsp/HotMV.jsp";
		
	}
	
	//跳转到下载客户端的页面
	@RequestMapping("/gotoDownloadClient")
	public String gotoDownloadClient(){
		return "/WEB-INF/jsp/DownLoadClient.jsp";
	}
	
	@Resource(name="indexService")
	private IndexService indexService;
	@Resource(name="musicService")
	private MusicService musicService;
	@Resource(name="mvService")
	private MVService mvService;
}
