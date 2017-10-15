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


//���һ��Controller
@Controller("userController")
public class UserController {
	//ע��
	@RequestMapping("/Register")
	public @ResponseBody String register(HttpServletRequest request,HttpServletResponse response,HttpSession session)  {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//����uuid����
		String id = UUID.randomUUID().toString();
		password = GetMD5.getMD5(password);
		User user = new User(id,username,password);
		int count = userService.testUserIsRegister(user);
		//ע����û���������,�������ݿ�
		if(count == 0){	//ע��ɹ�
			session.setAttribute("user",user);	//�Զ���¼
			userService.addUserToDb(user);
			return "1";
			
		}
		//ע��ʧ��
		return "0";
	}	
	//��ת��ע��ҳ��
	@RequestMapping("/gotoRegisterPage")
	public ModelAndView gotoRegisterPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/Register.jsp");
		return modelAndView;
	} 
	
	//�ض���ע��ɹ�ҳ��
	@RequestMapping("/gotoRegisterSuccessPage")
	public ModelAndView gotoRegisterSuccessPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/RegisterSuccess.jsp");
		return modelAndView;
	}
	
	//��¼����
	@RequestMapping("/Login")
	public @ResponseBody String Login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		password = GetMD5.getMD5(password);	
		User user = new User(username,password);
		int count = userService.testUserLogin(user);
		if(count == 1){
			//�Ӷ��򵽵�¼�ɹ�ҳ��
			System.out.println("��¼�ɹ�");
			user = userService.selUserByUserName(user.getUsername());
			session.setAttribute("user",user);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*20);
			cookie.setPath("Mp3Player");			
			response.addCookie(cookie);
			
		//	return "/WEB-INF/jsp/LoginSuccess.jsp";
			return "1";
		}else{
			//���µ�¼
			System.out.println("��¼ʧ��");
		//	return "gotoIndex.jsp";
			return "0";
		}
	}
	//��ת����¼ҳ��
	@RequestMapping("/gotoLoginPage")
	public ModelAndView gotoLoginPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/Login.jsp");
		return modelAndView;
	}
	//�ض��򵽵�¼�ɹ�ҳ��
	@RequestMapping("/gotoLoginSuccessPage")
	public ModelAndView gotoLoginSuccessPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/LoginSuccess.jsp");
		return modelAndView;
	}
	//ע��
	@RequestMapping("/unLogin")
	public String unLogin(HttpSession session){
		session.removeAttribute("user");
		return "gotoIndex.jsp";
	}
	
	@Resource(name="userService")
	private UserService userService;
}
