package com.neusoft.product_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;

/**
 * Servlet implementation class prodele
 */
@WebServlet("/prodele.do")
public class prodele extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prodele() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ProductDao pro=DaoFactory.getInstance("productDao");
		response.setContentType("text/html;charset=UTF-8");
		String Id = request.getParameter("Id");
		int id=Integer.parseInt(Id);
		pro.deletePro(id);
		request.getRequestDispatcher("Propage.do").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
