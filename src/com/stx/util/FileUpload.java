package com.stx.util;

import java.io.File;
import java.util.UUID;

public class FileUpload {
	//���ϴ��ļ�����Ψһ���ļ���
	public static String generateFileName(String fileName){
		//UUID_fileName
		return UUID.randomUUID().toString()+"_"+fileName;
	}
	
	//���ϴ��ļ���ɢ�����Ŀ¼
	public static String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;	//��ϣֵ�ĵ�4λ
		int dir2 = (hashcode>>4)&15;	//��ϣֵ��5-8λ
		String savepath = path+File.separator+dir1+File.separator+dir2;
		File file = new File(savepath);
		if(!file.exists()){	//���Ŀ¼�����ڣ��򴴽�Ŀ¼
			file.mkdirs();
		}
		return savepath;
	}
}
