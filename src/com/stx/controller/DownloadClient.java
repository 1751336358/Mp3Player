package com.stx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadClient extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
	//	System.out.println("下载的文件名是:"+filename);
		String path = this.getServletContext().getRealPath("/Soft")+File.separator+filename;
	//	System.out.println("文件的路径是:"+path);
		File file = new File(path);
		if(file.exists()){
			System.out.println("文件不存在");
		}
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
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
