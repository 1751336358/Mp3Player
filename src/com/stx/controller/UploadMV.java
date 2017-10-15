package com.stx.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.stx.util.FileUpload;
import com.stx.util.JdbcUtils;
import com.stx.util.MapToSql;
import com.stx.util.TimeFormat;
import com.stx.util.WindowPath2LinuxPath;

public class UploadMV extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> map = new HashMap<String,String>();
		try {
			//1���½�����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024);	//������Ӳ��д���ݵĻ������Ĵ�С���˴���1M
			factory.setRepository(new File(this.getServletContext().getRealPath("/tmp")));	//�����ļ���ʱ����Ŀ¼
			//2���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*1000);	//���õ����ϴ��ļ��Ĵ�С����������Χ������FileUploadBase.FileSizeLimitExceededException�쳣
		//	upload.setSizeMax(0);	//�����ϴ��ļ����������ֵ
		//	upload.setProgressListener(new ProgressListenerImpl());	//���ü�����������������
			if(!upload.isMultipartContent(request)){	//�ж�ʱ�����multipart/form-data�ϴ���
				//���մ�ͳ��ʽ��ñ����ύ����
				//request.getParameter("username");
				return;
			}
			upload.setHeaderEncoding("utf-8");	//�����ϴ����ļ������� ��������
			//3�����ý���������request���õ������ϴ��ļ����浽list����
			List<FileItem> list = upload.parseRequest(request);
			//4������list���õ��ϴ���ÿ������(ÿ���ļ����浽list�� )
			for(FileItem item : list){
				if(item.isFormField()){	//����ύ���Ǳ��ֶ�
					String inputName = item.getFieldName();
					String inputValue = item.getString();
					inputValue = new String(inputValue.getBytes("iso-8859-1"),"utf-8");//����request�ı�������Ч��
				//	System.out.println(inputName+"="+inputValue);
					map.put(inputName, inputValue);	//filname
				}else{	//����ύ�����ϴ����ļ�
					String mvName = item.getName();
					InputStream in = item.getInputStream();
				//	System.out.println("fileName"+fileName);
					
					//�ж��û��Ƿ�û���ϴ��ļ���������Ϊ��
					if(mvName == null || mvName.trim().equals("")){
						continue;	//������һ��ѭ���������һ�������� 
					}
					//�˴����������û��ϴ��ļ�������
					String ext = mvName.substring(mvName.lastIndexOf("."));	//��ȡ�ϴ��ļ��ĺ�׺��
				//	System.out.println("�ļ��ϴ������ͣ�"+ext);
					if(ext == ".gif"){
						//��ϵͳ��֧�ָ����͵��ļ��ϴ�
						//request.getRequestDispatcher("").forward(request, response);
						return;
					}
					int len = 0;
					byte []buffer = new byte[1024];
				//	fileName = FileUpload.generateFileName(fileName);	//���ϴ����ļ�����Ψһ���ļ���
				//	String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					
					//filename�������ݿ⣬realname�ֶ�
					//�õ��ļ�id
					String id = UUID.randomUUID().toString();	//mv.id
					String savepath = "F:/Mp3Player/MV";
					savepath = FileUpload.generateSavePath(savepath, id);//���ϴ��ļ���ɢ�����Ŀ¼��F:/Mp3Player/aaa/bbb
					FileOutputStream out = new FileOutputStream(savepath+File.separator+id+ext);
					//�������ݿ��·��mvpath�ֶ�,ת��Ϊ/aaa/bbb/uuid.mp4
					String mvpath = WindowPath2LinuxPath.window2Linux(savepath);	//�������ݿ���ֶ�
					
				//	System.out.println("�ļ�����ʵ�ļ���:"+mvName);	//��Ҫ�������ݿ�
					System.out.println("�ļ�����ʵ�ļ���:"+mvName);	//��Ҫ�������ݿ�
					System.out.println("id:"+id);	//��Ҫ�������ݿ�					
					mvpath = mvpath+"/"+id+ext;
					System.out.println("mvpath:"+mvpath);	//��Ҫ�������ݿ�
					
					map.put("id", id);
					map.put("mvpath", mvpath);
					map.put("mvname", mvName);
					
					
					
					System.out.println("---------����map����");
					for(String key:map.keySet()){
						String value = (String)map.get(key);
						System.out.println(key+"-->"+value);
					}
					//���ϴ���Ϣ�������ݿ�
					String sql = MapToSql.mapToSqlForMV(map);
					System.out.println("ƴ�ӵ�sql��䣺"+sql);
					try {
						Connection conn = JdbcUtils.getConnection();
						PreparedStatement pstm = conn.prepareStatement(sql);
						ResultSet rs = null;
						pstm.executeUpdate();	//��mv��Ϣ����mv��
						sql = "update music set mvid=? where id=?";
						pstm = conn.prepareStatement(sql);
						pstm.setString(1, map.get("id"));
						pstm.setString(2,map.get("musicid"));
						pstm.executeUpdate();
						
						JdbcUtils.release(conn, pstm, rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//���������music����mvid�ֶ�
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
					item.delete();	//�ϴ����ļ����Զ���������ʱĿ¼�У����ļ��ϴ����ʱ���Զ�ɾ����ʱ�ļ����ϴ����ļ�
					System.out.println("�ϴ��ɹ�������");
					response.sendRedirect("/Mp3Player/gotoIndex.jsp");
				}
			}
			
		}catch (FileUploadBase.FileSizeLimitExceededException e) {	//�ϴ��ļ���С����ָ����С
			System.out.println("�ϴ����ļ�̫��");
		//	request.setAttribute("message","�ϴ��ļ���С���ܳ���5M");
		//	request.getRequestDispatcher("").forward(request, response);
		// 	return;
		} 
		catch (FileUploadException e) {
			
			e.printStackTrace();
		}
	}
	

}



