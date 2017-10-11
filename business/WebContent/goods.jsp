<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/show.css" />
	</head>
	<body>
		<!-- 商品列表 -->
			 <div >
			<form action="/" method="get" id="show"  >
				<div class="change_div_1_class" id="change_div_1_id">
				    <button  class="change_div_1_" id="change_div_add"  ><a href="#">添加</a></button>
				    <button class="change_div_1_" id="change_div_delete" ><a onclick="openChild(this)">删除</a></button>
				    <button class="change_div_1_" id="change_div_re"><a>回收</a></button>
					<button class="change_div_1_" id="change_div_re"><a>添加</a></button>
					<input placeholder="商品编号/名称" name="pro_search" id="change_div_1_input class="change_div_1_input"/>
				   <button class="change_div_1_" id="change_div_search"><a>搜索</a></button>
				</div>
			</form>
				 <div class="div_1_" id="div_1-input0">
				    <input class="div_1_input" id="div1_input0" type="checkbox" onlick="">
				 	<div class="div_1_number" id="div_1_number0">编号</div>
				 	<div class="div_1_number1" id="div_1_number0">货号</div>
				 	<div class="div_1_name" id="div_1_number0">名称</div>
				 	<div class="div_1_photo" id="div_1_number0">图片</div>
				 	<div class="div_1_stock" id="div_1_number0">类别</div>
				 	<div class="div_1_grounding" id="div_1_number0">价格</div>
				 	<div class="div_1_grounding1" id="div_1_number0">上架</div>
				 	<div class="div_1_update" id="div_1_update"><a>修改</a></div>
				 	<div class="div_1_delete" id="div_1_delete"><a>删除</a></div>
				</div>	
				
				
				<%   Object obj=request.getAttribute("product");
             if(obj!=null){// 
       	     PageModel<Product> pp=(PageModel<Product>)obj;
       	     CateDao s=new CateDaoImpl();
       	    
      	     String online=null;
             String cate=null;
              for(int j=0;j<pp.getDatas().size();j++){
            	  if(pp.getDatas().get(j).getOnline()==1){
            		  online="是";
            	  }else{
            		  online="否";
            	  }
            	  cate=s.getCat(pp.getDatas().get(j).getCid()).getCname();
            	  %>
  
				 	
				 	
				 	
				  <div class="div_1_" id="div_1-input<%=j%>">
				    <input class="div_1_input" id="div1_input<%=j%>" type="checkbox" onlick="">
				 	<div class="div_1_number" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getId() %></div>
				 	<div class="div_1_number1" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPno() %></div>
				 	<div class="div_1_name" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPname() %></div>
				 	<div class="div_1_photo" id="div_1_number<%=j%>"><img style="width:61px;height:61px;" src="img/<%=pp.getDatas().get(j).getPic() %>"/></div>
				 	<div class="div_1_stock" id="div_1_number<%=j%>"><%=cate%></div>
				 	<div class="div_1_grounding" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPrice() %></div>
				 	<div class="div_1_grounding1" id="div_1_number<%=j%>"><%=online%></div>
				 	<div class="div_1_update" id="div_1_update"><a>修改</a></div>
				 	<div class="div_1_delete" id="div_1_delete"><a>删除</a></div>
				</div>	
				    </form>
				 	<%}
				 	
				 	%>
			<div style="margin-left:120px" >
				共<%=pp.getTotalcount() %>条记录 <%=pp.getPageNo()%>/<%=pp.getTotalPageSize()%>页
				&nbsp;<a href="catepage.do?pageNo=1&pageSize=5" onclick="topPage()" >首页</a> 
				<a href="catepage.do?pageNo=<%=pp.getPageNo() - 1==0?pp.getPageNo():pp.getPageNo() - 1%>&pageSize=5" onclick="previousPage()">上一页</a>&nbsp;
				<a href="catepage.do?pageNo=<%=pp.getPageNo() + 1==pp.getTotalPageSize()?pp.getTotalPageSize():pp.getPageNo() +1%>&pageSize=5" onclick="nextPage()">下一页</a> 
				<a href="catepage.do?pageNo=<%=pp.getTotalPageSize()%>&pageSize=5" onclick="bottomPage()" >尾页</a>
				&nbsp;第<select onChange="if(this.value==1){location='http://localhost:8080/Message/addmsg.do?reqType=2&pageNo=1&pageSize=5'}else{location='http://localhost:8080/Message/addmsg.do?reqType=2&pageNo='+this.value+'&pageSize=5'}this.disabled='disabled'">
        <%
           if(pp!=null){
        	   int _totalPageSize=pp.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(pp.getPageNo()==(i+1)){%>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			  <option value="<%=i+1 %>" ><%=(i+1)%></option>
        		  <%
        		  }
        	   }
           }
             }
            %> 
        
						</select>页
				</div>
				
				
				
				
			</div>
			
			
			
	  
	
	</body>
</html>