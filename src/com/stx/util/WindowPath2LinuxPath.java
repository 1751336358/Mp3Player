package com.stx.util;

import java.io.File;

public class WindowPath2LinuxPath {
	//将window下的路径转化为Linux下的路径，例如F:\MpePlayer\bbb\aaa.mp3转化为/bbb/aaa.mp3
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
