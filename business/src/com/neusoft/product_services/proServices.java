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
	 * ��ҳ��ʾ
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
	 * ���
	 *     ��Ʒ����  pro_name
	 *      ��Ʒ��� type 
	 *      ���� pro_no 
	 *      ��� pro_spec  
	 *      �ϴ���Ƭ pro_img_src
	 *      ��Ʒ�۸� pro_price 
	 *      �Ƿ�����  pro_sx�� 1��0 
	 *       ��Ʒ����edit
	 *      
	 * **/
	
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		String pname = request.getParameter("pro_name");
		String region = request.getParameter("type");
		int cid=cate.getCatByName(region).getCid();
		
		String pno = request.getParameter("pro_no");
		//String pro_spec = request.getParameter("pro_spec");//���
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
 * ����id��ѯ��Ϣ
 * 
 * */
	public Product getProById(int id){
		return pro.getPro(id);
	}

	//�޸�
		public boolean modiflyPro(Product product){
			return pro.updatePro(product);
		}
		
		//ɾ��
		public boolean delPro(int id){
			return pro.deletePro(id);
		}




















}
	
	
	
	

