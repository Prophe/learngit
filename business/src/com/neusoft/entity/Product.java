package com.neusoft.entity;

import java.io.Serializable;

/*
 * 商品表
 * **/
public class Product implements Serializable {

	
	
	private static final long serialVersionUID = -3243256919166839069L;
	
	/*
	 * id         -- 商品编号，主键
   pname       -- 商品名称
   cid         -- 外键，引用自cate表中的cid 商品类别
   pno         -- 货号
   pic         -- 商品图片
   price        -- 商品价格
   online      -- 1:上线  0:下线 
   pdetail     -- 商品详情
   
	   id,pname,cid,pno,pic,price,online,pdetail
   **/
	
	private  int id;
	private  String pname;
	private  int cid;
	private  String pno;
	private  String pic;
	private  double price;
	private  int online;
	private  String pdetail;
	private  int isis;
	
	//pname,cid,pno,pic,price,online,pdetail,isis
	
	
	public Product() {
		super();
	}
	
	
	
	public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}







	public Product(int id, String pname, int cid, String pno, String pic, double price, int online, String pdetail,
			int isis) {
		super();
		this.id = id;
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
		this.isis = isis;
	}



	public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail, int isis) {
		super();
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
		this.isis = isis;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public int getIsis() {
		return isis;
	}
	public void setIsis(int isis) {
		this.isis = isis;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic + ", price="
				+ price + ", online=" + online + ", pdetail=" + pdetail + ", isis=" + isis + "]";
	}
	
	
	
	
	
	
	
}
