package com.stx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mp3Filter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String []ends = {".mp3",".mp4",".jpg",".png",".css",".js"};
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String url = request.getRequestURI();
		int cachetime = 0;	//缓存时间
		for(int i = 0;i<ends.length;i++){
			if(url.endsWith(ends[i])){
				cachetime = 1000;
				break;
			}
		}
	//	System.out.println("拦截的url是："+url+",缓存时间是："+cachetime);
		//设置缓存时间
		response.setDateHeader("expires", System.currentTimeMillis()+(cachetime*60*1000));
		chain.doFilter(request, response);	//放行
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
