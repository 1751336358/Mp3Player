package com.stx.util;

import java.io.File;

public class WindowPath2LinuxPath {
	//��window�µ�·��ת��ΪLinux�µ�·��������F:\MpePlayer\bbb\aaa.mp3ת��Ϊ/bbb/aaa.mp3
	public static String window2Linux(String path){
		StringBuffer sb = new StringBuffer(path);
		for(int i = 0;i<sb.length();i++){
			char c = sb.charAt(i);
			if(c == File.separatorChar){
				sb.replace(i, i+1, "/");
			}
		}
		sb.replace(0, 12, "");
		return sb.toString();
	}
}
