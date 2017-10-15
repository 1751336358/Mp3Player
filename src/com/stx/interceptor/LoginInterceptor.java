package com.stx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.stx.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String url = request.getRequestURI();	
	//	System.out.println("拦截的url是："+url);
		
		if(url.startsWith("/Mp3Player/gotoUploadPage") || url.startsWith("/Mp3Player/SelMusicByUserId")){
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if(user != null){	//如果已经登录，放行
				return true;
			}else{	//如果没有登录，跳转到登录页面
				request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
				return false;
			}
		}
		
		//其他地址不拦截
		return true;
	}
	
	//
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
