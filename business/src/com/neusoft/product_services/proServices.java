package com.neusoft.product_services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public class proServices {


	 ProductDao pro=DaoFactory.getInstance("productDao");
	 CateDao cate=DaoFactory.getInstance("cateDao");

	/**
	 * 分页显示
	 * 
	 * ***/
	public PageModel<Product> getPageModelpro(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		PageModel<Product>  product=null;
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="5";
		}
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			
			product=getPageModel(_pageNo,_pageSize);
			if(product!=null) {
				int totalPageSize= (product.getTotalcount()%_pageSize==0?product.getTotalcount()/_pageSize:product.getTotalcount()/_pageSize+1);
				product.setTotalPageSize(totalPageSize);
				product.setPageNo(_pageNo);
			}
			
			request.setAttribute("product", product);
			request.getRequestDispatcher("goods2.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		

		return product;
		
		
		
		
	}
	
	
	public PageModel<Product> getPageModel(int pageNo, int pageSize){
		PageModel<Product> product=pro.getPageModel(pageNo, pageSize);
		return product;
	}

	/**
	 * 添加
	 *     商品名称  pro_name
	 *      商品类别 type 
	 *      货号 pro_no 
	 *      规格 pro_spec  
	 *      上传照片 pro_img_src
	 *      商品价格 pro_price 
	 *      是否上线  pro_sx是 1否0 
	 *       商品详情edit
	 *      
	 * **/
	
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		String pname = request.getParameter("pro_name");
		String region = request.getParameter("type");
		int cid=cate.getCatByName(region).getCid();
		
		String pno = request.getParameter("pro_no");
		//String pro_spec = request.getParameter("pro_spec");//规格
		String pic = request.getParameter("pro_img_src");
		int price =Integer.parseInt(request.getParameter("pro_price"));
		int online = Integer.parseInt(request.getParameter("pro_sx"));
		String pdetail = request.getParameter("edit");
	
	   
	   boolean flag= pro.insert(new Product(pname, cid, pno, pic, price, online, pdetail));
	if(flag){
		request.getRequestDispatcher("Propage.do").forward(request, response);
	}else{
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	}
	
/**
 * 根据id查询信息
 * 
 * */
	public Product getProById(int id){
		return pro.getPro(id);
	}

	//修改
		public boolean modiflyPro(Product product){
			return pro.updatePro(product);
		}
		
		//删除
		public boolean delPro(int id){
			return pro.deletePro(id);
		}




















}
	
	
	
	

