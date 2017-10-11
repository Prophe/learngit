package com.neusoft.entity;

import java.io.Serializable;

/**
 * 买家购物信息
 * @author Administrator
 *
 */
public class Shoppinginfo_Consumer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627837547520953592L;
	
	
	
	private int id; 
	private int aid;	//买家购物信息id
	private String nickname; //昵称
	private Double money;	//话费金额
	private Long lasttime;	//最后一次登陆时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Long getLasttime() {
		return lasttime;
	}
	public void setLasttime(Long lasttime) {
		this.lasttime = lasttime;
	}
	
	@Override
	public String toString() {
		return "Shoppinginfo_Consumer [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", money=" + money
				+ ", lasttime=" + lasttime + "]";
	}
	

}
