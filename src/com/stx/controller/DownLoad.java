package com.stx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.util.JdbcUtils;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class DownLoad extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
		String musicpath = request.getParameter("musicpath");
		//将下载量+1
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "update music set downloadnum=downloadnum+1 where id like ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,id);
			pstm.executeUpdate();
			JdbcUtils.release(conn, pstm, null);
		} catch (SQLException e1) {
			
		}
		
		//文件下载，下面的几行代码解决在火狐下的下载文件乱码问题
		String agent = (String)request.getHeader("USER-AGENT");
		if(agent != null && agent.toLowerCase().indexOf("firefox")>0){
			filename = "=?UTF-8?B?"+(new String(Base64.encode(filename.getBytes("UTF-8"))))+"?=";
		}else{
			filename = URLEncoder.encode(filename,"utf-8");
		}
		String root = "F:/Mp3Player";	//音乐所在的根目录
	/*	System.out.println("id:"+id);
		System.out.println("filename:"+filename);
		System.out.println("musicpath:"+musicpath);*/
		
		
		//得到文件的实际路径
	
		File file = new File(root+musicpath);
		
		if(!file.exists()){	//所下载的文件不存在
			System.out.println("文件不存在");
			//跳转
			return;
		}
	//	response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setContentLength((int)file.length());
		InputStream in = null;
		OutputStream out = null;
		try{ 
			in = new FileInputStream(file);//读文件
			int len = 0;
			byte []buf = new byte[1024];
			out = response.getOutputStream();
			while((len = in.read(buf)) > 0)
			{
				out.write(buf,0,len);//写入response对象
			}
		}finally{//关闭流
			if(in != null){
				try{
					in.close();
				}catch(Exception e){}
			}
			if(out != null){
				try{
					out.close();
				}catch(Exception e){}
			}
		}
		
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
}
