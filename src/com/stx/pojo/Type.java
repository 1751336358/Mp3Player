package com.stx.pojo;

public class Type {
	private int id;
	private String typename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Type(int id, String typename) {
		super();
		this.id = id;
		this.typename = typename;
	}
	public Type() {
		super();
	}
	
}
