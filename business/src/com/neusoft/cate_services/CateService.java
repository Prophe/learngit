package com.neusoft.cate_services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.Dao.DaoFactory;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public class CateService {

	
	CateDao ca= DaoFactory.getInstance("cateDao");
	
	
	/**
	 * 添加分类
	 * 
	 * **/
	public void  addCateForP(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		String cname= request.getParameter("cname");
		 if(cname==null||cname.equals("")) {
			 throw new DaoException("用户名不能为空");
		 }
		 int pid=0;
		 String pname= request.getParameter("pname");
		 if(pname==null||pname.equals("")) {
			 pid=0;
		 }else{
			pid=getCPidFromName(pname).getCid();
		 }
		
		 Cate cate=new Cate(cname, pid);
		 boolean flag=AddCat(cate);
		 request.setAttribute("addCateForP", flag);
		if(flag){
			request.getRequestDispatcher("catepage.do").forward(request, response);
		}
		 
		 
	}
	
	
	/**
	 * 查询上级分类
	 * 
	 * */
	
	public Cate getCPidFromid(){
		
		Cate cate =ca.getCatByPid();
		return cate;
	
	}
	/**
	 * 根据姓名获取上级分类id
	 * */
	public Cate getCPidFromName(String name){
		Cate cate =ca.getCatByName(name);
		return cate;
	}
	/**
	 * 添加方法
	 * */
	public boolean AddCat(Cate cate){

		if(ca.insert(cate)){
			return true;
		}else{
			return false;	
		}
		
	}
	
	
	/**
	 * 分页查询数据
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 * 
	 * */
	
	
	public PageModel<Cate> getPageModelToP(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		PageModel<Cate>  cate=null;
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="5";
		}
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			
			cate=getPageModel(_pageNo,_pageSize);
			if(cate!=null) {
				int totalPageSize= (cate.getTotalcount()%_pageSize==0?cate.getTotalcount()/_pageSize:cate.getTotalcount()/_pageSize+1);
				cate.setTotalPageSize(totalPageSize);
				cate.setPageNo(_pageNo);
			}
			
			request.setAttribute("cate", cate);
			request.getRequestDispatcher("cate.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return cate;
	}
	
	/**
	 * 分页查询数据
	 * 
	 * **/
	
	public PageModel<Cate> getPageModel(int pageNo, int pageSize){
		PageModel<Cate> cate=ca.getPageModel(pageNo, pageSize);
		return cate;
	}

   /**
    * 修改分类
    * 
    * */
	public void  upCateForP(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		String cid=	request.getParameter("cid");
		int upcid= Integer.parseInt(cid);
		String cname= request.getParameter("upcname");
		 
		 int pid=0;
		 String pname= request.getParameter("uppname");
		 if(pname==null||pname.equals("")) {
			 pid=0;
		 }else{
			pid=getCPidFromName(pname).getCid();
		 }
	
		 Cate cate=new Cate(upcid,cname, pid);
		 System.out.println(cate);
		 upCat(cate);
		
		request.getRequestDispatcher("catepage.do").forward(request, response);
		
		
	}
    public Cate getCateBycid (int cid){
    	
    	Cate cate =ca.getCat(cid);
		return cate;
    	
    }
    /**
     * 修改分类
     * */
    public boolean upCat(Cate cate){
    	
    	if(ca.updateCat(cate)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
    
    
    
    
    
    
/**
 * 删除分类
 * **/
    public void deleCateForP(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
    	String cid=	request.getParameter("cid"); 
    	int delcid= Integer.parseInt(cid);
    	if(ca.getCat(delcid).getPid()!=0){
    		ca.deleteCat(delcid);
    	}else{
    		List<Cate> list=ca.getCatByPid(delcid);
    		for (Cate cate : list) {
    			ca.deleteCat(cate.getCid());
			}
    		ca.deleteCat(delcid);
    	}
    	request.getRequestDispatcher("catepage.do").forward(request, response);
    }


}








