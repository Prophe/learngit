package com.neusoft.entity;

import java.io.Serializable;


/*
 * Àà±ð±í
 * **/

public class Cate implements Serializable{

	/**
	 *  cid,cname,pid
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int cid;
	private String cname;
	private int pid;
	
	
	public Cate(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Cate() {
		super();
	}
	
	public Cate(String cname) {
		super();
		this.cname = cname;
	}

	public Cate(String cname, int pid) {
		super();
		this.cname = cname;
		this.pid = pid;
	}

	public Cate(int cid, String cname, int pid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
	
	
}
