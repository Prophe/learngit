package com.neusoft.cate_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.cate_services.CateService;

/**
 * Servlet implementation class CateServlet
 */
@WebServlet("/addcate.do")
public class CateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  reqType=1
		
		response.setContentType("text/html;charset=UTF-8");
		
		//获取添加或者查询请求 addcate.do?reqType=1
	   String reqType=	request.getParameter("reqType");
	   System.out.println(reqType);
		 if(reqType==null||reqType.equals("")) {
			 request.getRequestDispatcher("cate.jsp").forward(request, response);
		 }
		 else if(reqType.equals("1")){
		   new CateService().addCateForP(request, response);
		   
//		   request.getRequestDispatcher("").forward(request, response);
		}else if(reqType.equals("2")){
			
			 new CateService().getPageModelToP(request, response);
			
		}else if(reqType.equals("3")){
			System.out.println(request.getParameter("upcname"));
			 new CateService().upCateForP(request, response);
		}else if(reqType.equals("4")){
			 new CateService().deleCateForP(request, response);
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
