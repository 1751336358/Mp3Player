package com.stx.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;


public class MapToSql {
	public static String mapToSqlForMusic(Map map){
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into music(id,filename,musicpath,time,singname,userid,username,typeid,downloadnum) values(");		
		sql.append("'"+map.get("id")+"',");
		sql.append("'"+map.get("filename")+"',");
		sql.append("'"+map.get("musicpath")+"',");
		sql.append("'"+map.get("time")+"',");
		sql.append("'"+map.get("singname")+"',");
		sql.append("'"+map.get("userid")+"',");
		sql.append("'"+map.get("username")+"',");
		sql.append(map.get("typeid")+",");
		sql.append(map.get("downloadnum"));
		sql.append(")");
		return sql.toString();
	}
	
	
	public static String mapToSqlForMV(Map map){
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into mv(id,mvname,mvpath) values(");		
		sql.append("'"+map.get("id")+"',");
		sql.append("'"+map.get("mvname")+"',");
		sql.append("'"+map.get("mvpath")+"'");
		sql.append(")");
		return sql.toString();
	}
	@Test
	public void test1(){
		Map map = new LinkedHashMap<String, String>();
		map.put("id","uuid");
		map.put("mvname","aaa.mp3");
		map.put("mvpath","/15/12/4d70837e");
		
		System.out.println(mapToSqlForMV(map));
	}
}
