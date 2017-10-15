package com.stx.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stx.pojo.User;
import com.stx.service.UserService;
import com.stx.util.GetMD5;


//标记一个Controller
@Controller("uploadController")
public class UploadController {
	
	//跳转到上传文件的页面UploadPage.jsp
	@RequestMapping("/gotoUploadPage")
	public ModelAndView gotoUploadPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/UploadPage.jsp");
		return modelAndView;
	}
	
	@Resource(name="userService")
	private UserService userService;
}
