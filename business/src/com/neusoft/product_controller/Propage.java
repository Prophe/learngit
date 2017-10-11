 package com.neusoft.product_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.product_services.proServices;

/**
 * Servlet implementation class Propage
 */
@WebServlet("/Propage.do")
public class Propage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public Propage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="5";
		}
	
		    request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			new proServices().getPageModelpro(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
