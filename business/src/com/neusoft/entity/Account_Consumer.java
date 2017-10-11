package com.neusoft.entity;

import java.io.Serializable;


/**
 * 买家帐号信息
 * @author Administrator
 *
 */
public class Account_Consumer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3585305766067136195L;
	/**
	 * 
	 */
	
	
	private int id;	//买家id
	private String loginname;	//用户名
	private String password;	//密码
	private Long registertime;	//注册时间
	private long lastlogintime;	//最后一次登陆时间
	private String ip;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Long registertime) {
		this.registertime = registertime;
	}
	public Long getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Long lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Account_Consumer [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
				+ registertime + ", lastlogintime=" + lastlogintime + ", ip=" + ip + "]";
	}
	
	
	
	
	
}
