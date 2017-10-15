package com.stx.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//���������ֻ���post����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		filterChain.doFilter(new MyRequest(request), response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


//HttpServletRequestWrapper��Ĭ�ϵ�HttpServletRequest����ǿ�࣬�Ѿ���д��HttpServletRequest�����еķ���
class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	//��д��Ҫ��ǿ�ķ�������ǿgetParameter����
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if(value == null){
			return null;
		}
		//�������get��ʽ�ύ
		if(!this.request.getMethod().equalsIgnoreCase("get")){
		//	value = HtmlFilter.filter(value); //html�ı�ת��
			return value;
		}
		//����get����
		try {
			value = new String(value.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}


