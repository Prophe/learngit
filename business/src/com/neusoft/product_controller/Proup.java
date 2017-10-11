package com.neusoft.product_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;
import com.neusoft.entity.Product;
import com.neusoft.product_services.proServices;

/**
 * Servlet implementation class Proup
 */
@WebServlet("/Proup.do")
public class Proup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 ProductDao pro=DaoFactory.getInstance("productDao");
	 CateDao cate=DaoFactory.getInstance("cateDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String update = request.getParameter("update");
		String Id = request.getParameter("Id");
		int id=Integer.parseInt(Id);
		if(update.equals("1")){
			
			proServices p=new proServices();
			
			request.setAttribute("oldpro", p.getProById(id));
			request.getRequestDispatcher("proup.jsp").forward(request, response);
		}else {
			String pname = request.getParameter("pro_name");
			String region = request.getParameter("type");
			int cid=cate.getCatByName(region).getCid();
			
			String pno = request.getParameter("pro_no");
			//String pro_spec = request.getParameter("pro_spec");//¹æ¸ñ
			String pic = request.getParameter("pro_img_src");
			int price =Integer.parseInt(request.getParameter("pro_price"));
			int online = Integer.parseInt(request.getParameter("pro_sx"));
			String pdetail = request.getParameter("edit");
			boolean flag=pro.updatePro(new Product(id, pname, cid, pno, pic, price, online, pdetail, 0));
		 
		if(flag){
			request.getRequestDispatcher("Propage.do").forward(request, response);
		}else{
			request.getRequestDispatcher("goods2.jsp").forward(request, response);
		}

		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
