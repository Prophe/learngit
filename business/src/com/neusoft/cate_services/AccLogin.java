package com.neusoft.cate_services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.AccountDao;
import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoFactory;
import com.neusoft.entity.Account;

public class AccLogin {
	AccountDao acc= DaoFactory.getInstance("accountDao");
	
	
	public void accLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name= request.getParameter("Accname");
		
		String password= request.getParameter("Accpassword");
      
	
	}	
	
	
	public boolean dologin(Account account){
		acc.doLogin(account);
	
		return false;
		
	}
}
