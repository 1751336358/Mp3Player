package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.pojo.Say;

public interface SayService {
	
	//���û����۲������ݿ�
	public Say addSay(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	//�鿴�������ۣ�����musicid
	public List<Say> SelAllSay(String musicid);
	
	//ɾ�����ۣ�����say.id
	public void delSayById(String id);
	
}