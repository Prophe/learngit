package com.neusoft.entity;

import java.io.Serializable;

public class Rule implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = -1959216252196591736L;
	private int id;	//规格id
	private int pid;	//引用商品id
	private String	size;	//屏幕尺寸大小 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Rule [id=" + id + ", pid=" + pid + ", pm_size=" + size + "]";
	}
	
	
}

