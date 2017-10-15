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


//���һ��Controller
@Controller("indexController")
public class IndexController {
	@RequestMapping("/gotoIndex")
	public ModelAndView gotoIndex(){
		ModelAndView modelAndView = new ModelAndView();
		//���Ÿ���
		List<Music> hotMusic = HotMusic(11);	//��ҳչʾʱ���Ȳ��typeid=11�����֣�����
		modelAndView.addObject("hotMusic", hotMusic);
		//���Ÿ��֣����ݸ��ֵĳ����������ѯ�����������͸���,ǰʮ��
		List<HotSingname> hotSingname = SelSingCountBySingname();
		//�鿴���еķ����type.id
		List<Type> types = SelTypeId();
		System.out.println("����ĸ���"+types.size());
		//��ѯ�Ȳ�MV
		List<HotMV> hotMv = indexService.SelHotMv(); 
		System.out.println("����MV������"+hotMv.size());
		modelAndView.addObject("hotSingname", hotSingname);
		modelAndView.addObject("types", types);
		modelAndView.addObject("hotMv", hotMv);
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
	
	//�鿴���е�����
	public List<Music> AllMusic(){
		List<Music> listMusic = indexService.AllMusic();
		System.out.println("���ֵĸ�����"+listMusic.size());
	
		return listMusic;
	}
	
	//����type.id����ѯ��������
	@RequestMapping("/HotMusic/{typeid}")
	public @ResponseBody List<Music> HotMusic(@PathVariable("typeid") int typeid){
		System.out.println("typeid="+typeid);
		
		List<Music> listMusic = indexService.HotMusic(typeid);
		System.out.println("��ѯ���ļ�¼��:"+listMusic.size());
		return listMusic;
	}
	
	// ���Ÿ��֣����ݸ��ֵĳ����������ѯ�����������͸���,ǰʮ��
	public List<HotSingname> SelSingCountBySingname(){
		return musicService.SelSingCountBySingname();
	}
	
	////�鿴���еķ����type.id
	public List<Type> SelTypeId(){
		return indexService.SelTypeId();
	}
	
	//���ݹؼ�������
	@RequestMapping("/SelByKey")
	public String SelByKey(String key,Model model){
		List<Music> musicList = indexService.SelByKey(key);
		model.addAttribute("musicList",musicList);
		model.addAttribute("message", key);
		return "/WEB-INF/jsp/ListMusicModel.jsp";
		
	}
	
	//��ת���Ȳ�MV�Ľ���
	@RequestMapping("/gotoHotMV/{mvid}")
	public String gotoHotMV(@PathVariable("mvid") String mvid,Model model){
		//��mv��playnum+1
		mvService.UpdatePlaynumByMvId(mvid);
		//����mvid��mv���ѯ��mv����Ϣ
		MusicMV musicMV = mvService.SelMusicMVByMvId(mvid);
		model.addAttribute("musicMV", musicMV);
		return "/WEB-INF/jsp/HotMV.jsp";
		
	}
	
	//��ת�����ؿͻ��˵�ҳ��
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
