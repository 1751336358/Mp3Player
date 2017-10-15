package com.stx.util;

import java.io.File;
import java.util.UUID;

public class FileUpload {
	//给上传文件赋予唯一的文件名
	public static String generateFileName(String fileName){
		//UUID_fileName
		return UUID.randomUUID().toString()+"_"+fileName;
	}
	
	//将上传文件打散到多个目录
	public static String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;	//哈希值的低4位
		int dir2 = (hashcode>>4)&15;	//哈希值的5-8位
		String savepath = path+File.separator+dir1+File.separator+dir2;
		File file = new File(savepath);
		if(!file.exists()){	//如果目录不存在，则创建目录
			file.mkdirs();
		}
		return savepath;
	}
}
