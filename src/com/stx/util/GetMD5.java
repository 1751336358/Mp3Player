package com.stx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class GetMD5 {
	//½«ÃÜÂë×ªÎªMD5Âë
	public static String getMD5(String str){
		MessageDigest md  = null;
		try {
			md = MessageDigest.getInstance("md5");
			byte [] md5 = md.digest(str.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			String last = encoder.encode(md5);
			return last;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
}
