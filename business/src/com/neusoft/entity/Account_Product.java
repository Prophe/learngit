package com.neusoft.entity;

import java.io.Serializable;

/**
 * �����ʺ���Ϣ
 * @author Administrator
 *
 */
public class Account_Product implements Serializable{



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7381765240604246706L;
	private int id;	
	private String loginname;	//���ҵ�½��
	private String password; 	//��������
	private Long registertime;	//ע��ʱ��
	private Long lastlogintime; //���һ�ε�½ʱ��
	private String ip;	//ip��ַ
	
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
		return "Account_Product [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
				+ registertime + ", lastlogintime=" + lastlogintime + ", ip=" + ip + "]";
	}
	
	
	
	
}
