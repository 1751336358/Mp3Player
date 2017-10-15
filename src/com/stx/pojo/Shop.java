package com.stx.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Shop {
	@Size(min=3,max=7,message="�����볤��3-7���ַ�")
	private String name;
	@Min(0)
	@Max(100)
	private int age;
	@NotNull(message="���ڲ���Ϊ��")
	private String birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
