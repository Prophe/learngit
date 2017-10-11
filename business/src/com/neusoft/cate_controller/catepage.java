package com.neusoft.cate_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.cate_services.CateService;

/**
 * Servlet implementation class catepage
 */
@WebServlet("/catepage.do")
public class catepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public catepage() {
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
			new CateService().getPageModelToP(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
