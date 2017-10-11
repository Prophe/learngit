package com.neusoft.cate_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.cate_services.CateService;
import com.neusoft.entity.Cate;

/**
 * Servlet implementation class CateUp
 */
@WebServlet("/upcate.do")
public class CateUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//获取修改或者删除请求  UpcId=
		   String reqType=	request.getParameter("UpcId");
			 if(reqType==null||reqType.equals("")) {
				 request.getRequestDispatcher("cate.jsp").forward(request, response);
			 }
			 else {
				int cid= Integer.parseInt(reqType);
				Cate cate=new CateService().getCateBycid(cid);
				String ycname=cate.getCname();
				request.setAttribute("ycid", reqType);
				request.setAttribute("ycname", ycname);
				request.getRequestDispatcher("upc.jsp").forward(request, response);
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
