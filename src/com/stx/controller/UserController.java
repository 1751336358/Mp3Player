package com.stx.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stx.pojo.User;
import com.stx.service.UserService;
import com.stx.util.GetMD5;


//标记一个Controller
@Controller("userController")
public class UserController {
	//注册
	@RequestMapping("/Register")
	public @ResponseBody String register(HttpServletRequest request,HttpServletResponse response,HttpSession session)  {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//生成uuid主键
		String id = UUID.randomUUID().toString();
		password = GetMD5.getMD5(password);
		User user = new User(id,username,password);
		int count = userService.testUserIsRegister(user);
		//注册的用户名不存在,插入数据库
		if(count == 0){	//注册成功
			session.setAttribute("user",user);	//自动登录
			userService.addUserToDb(user);
			return "1";
			
		}
		//注册失败
		return "0";
	}	
	//跳转到注册页面
	@RequestMapping("/gotoRegisterPage")
	public ModelAndView gotoRegisterPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/Register.jsp");
		return modelAndView;
	} 
	
	//重定向到注册成功页面
	@RequestMapping("/gotoRegisterSuccessPage")
	public ModelAndView gotoRegisterSuccessPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/RegisterSuccess.jsp");
		return modelAndView;
	}
	
	//登录界面
	@RequestMapping("/Login")
	public @ResponseBody String Login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		password = GetMD5.getMD5(password);	
		User user = new User(username,password);
		int count = userService.testUserLogin(user);
		if(count == 1){
			//从定向到登录成功页面
			System.out.println("登录成功");
			user = userService.selUserByUserName(user.getUsername());
			session.setAttribute("user",user);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*20);
			cookie.setPath("Mp3Player");			
			response.addCookie(cookie);
			
		//	return "/WEB-INF/jsp/LoginSuccess.jsp";
			return "1";
		}else{
			//重新登录
			System.out.println("登录失败");
		//	return "gotoIndex.jsp";
			return "0";
		}
	}
	//跳转到登录页面
	@RequestMapping("/gotoLoginPage")
	public ModelAndView gotoLoginPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/Login.jsp");
		return modelAndView;
	}
	//重定向到登录成功页面
	@RequestMapping("/gotoLoginSuccessPage")
	public ModelAndView gotoLoginSuccessPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/LoginSuccess.jsp");
		return modelAndView;
	}
	//注销
	@RequestMapping("/unLogin")
	public String unLogin(HttpSession session){
		session.removeAttribute("user");
		return "gotoIndex.jsp";
	}
	
	@Resource(name="userService")
	private UserService userService;
}
