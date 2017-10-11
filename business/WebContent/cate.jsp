<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类</title>
<script type="text/javascript" src="js/commodity.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/commodity.css"/>
		<link rel="stylesheet" href="css/leftmenu.css" />
		<link rel="stylesheet" href="css/show.css" />
		<link rel="stylesheet" type="text/css" href="css/cate.css"/>
		<script type="text/javascript" src="js/onclick.js" ></script>
		<script type="text/javascript" src="js/test00.js" ></script>
	</head>
	<body>
		<div id="main">
			<div style="background-color: #000000;">
				<img src="img/logo.png" style="padding-top: 16px;height: 40px;width: 40px; display:inline-block;"/>
				<a style="margin:0 auto;display:inline-block;font-size: 24px;color:white ;">微电商后台管理系统</a>
				<a href="home.jsp" id="exit">退出</a>
			</div>
			<div id="nav">
				
				<ul>  
					<li><a href="#">首页</a></li>
			        <li><a href="#">商品</a>
			        	<ul>  
			                <li><a href="#" onclick="testo00()">商品列表</a></li>  
			                <li><a href="#"  >商品分类</a></li>  
			                <li><a href="#">商品品牌</a></li>  
			                <li><a href="#">商品类型</a></li>  
			            </ul>          
			        </li>  
			        <li><a href="#">订单</a>  
			            <ul>  
			                <li><a href="#">待支付订单</a></li>  
			                <li><a href="#">已付款订单</a></li>  
			                <li><a href="#">已发货订单</a></li>  
			                <li><a href="#">已完成订单</a></li>  
			            </ul>          
			        </li>  
			        <li><a href="#">会员</a></li>  
			        <li><a href="#">营销</a></li>  
			        <li><a href="#">统计</a></li>  
			        <li><a href="#">系统</a></li>  
			        <li><a href="#">账号管理</a></li>  
			        
			    </ul>  
			</div>
			<div  style="background-image: url(img/bg1.png);">
				<div id="left">
					<div id="content">
						<div class="left_menu">
							<ul id="nav_dot">
						      <li>
						          <h4 class="M1" id="shangpin" onclick="dis1()"><span></span>商品管理</h4>
						          <div class="list-item none" id="shangpina" style="height: 0;"  >
						            <a href='Propage.do' >商品列表</a>
						            <a href="#" >商品类别维护</a>
						            
						            <a href='#' onclick="_shangpinguigeshuxing()"> 商品规格属性</a>
						            
						            
						          </div>
						        </li>
						    
								<li>
						          <h4 class="M4" id="dingdan" onclick="dis()" ><span></span>订单管理</h4>
						          <div class="list-item none" id="dingdana" style="height: 0;">
						            <a href='#'onclick="_huiyuanguanli1()">待支付订单</a>
						            <a href='#'onclick="_huiyuanguanli1()">已付款订单</a>
						            <a href='#'onclick="_huiyuanguanli1()">已发货订单</a>
						            <a href="#" >已完成订单</a>
						          </div>
						     
										<li>
						          <h4  class="M7"  ><span></span>会员管理</h4>
						          
						        </li>
								
										<li>
						          <h4  class="M9"><span></span>权限管理</h4>
						          
						        </li>
										<li>
						          <h4   class="M10"><span></span>系统管理</h4>
						          
						        </li>
						  </ul>
					</div>
				
				
				
			</div>
			
			
		</div>
		<div class="right" id="right">
		     <div >
			<form action="/" method="get" id="show"  >
				<div class="change_div_1_class" id="change_div_1_id">
				    <a class="change_div_1_" id="change_div_delete" >删除</a>
				    <a class="change_div_1_" id="change_div_re">回收</a>
					<a href="addc.jsp" class="change_div_1_" id="change_div_re">添加</a>
				   <a class="change_div_1_" id="change_div_search">搜索</a>
				</div>
				<div class="div_1_" id="div_1-input0">
				    <input class="div_1_input" id="div1_input0" type="checkbox">
				 	<div class="div_1_number" id="div_1_number0">编号</div>
				 
				 	<div class="div_1_name" id="div_1_number0">名称</div>
				 	<div class="div_1_stock" id="div_1_number0">类别</div>
				
				 	<div class="div_c_update" id="div_1_update">修改</div>
				 	<div class="div_c_delete" id="div_1_delete">删除</div>
				</div>	
		    </form>
		  
		    
		 <%   Object obj=request.getAttribute("cate");
             if(obj!=null){// 
       	  PageModel<Cate> cc=(PageModel<Cate>)obj;%>
	         	<% 	 CateDao s=new CateDaoImpl();
	         		
	              
	         		String ctp=null;
          
              for(int a=0;a<cc.getDatas().size();a++){
            	  if(cc.getDatas().get(a).getPid()==0){
            		  ctp="无";
            		  
            	  }else{
            		  ctp=s.getCat(cc.getDatas().get(a).getPid()).getCname();
            	  }
            	  %>
				    <form action="/" method="get" id="cate_"  >
				 	
				 	<div class="div_1_" id="div_1-input<%=a%>">
				    <input class="div_c_input" id="div1_input<%=a%>" type="checkbox" >
				 	<div class="div_1_number" id="div_1_number<%=a%>"><%=cc.getDatas().get(a).getCid() %></div>
				 	<div class="div_1_name" id="div_1_number<%=a%>"><%=cc.getDatas().get(a).getCname() %></div>
				 	<div class="div_1_stock" id="div_1_number<%=a%>"><%=ctp %></div>
	            	
				 	<div class="div_c_update" id="div_1_update"><a href="upcate.do?UpcId=<%=cc.getDatas().get(a).getCid() %>">修改</a></div>
				 	<div class="div_c_delete" id="div_1_delete"   ><a href="addcate.do?cid=<%=cc.getDatas().get(a).getCid()%>&reqType=4" >删除</a></div>
				   </div>
				 
				    </form>
				 	<%}
				 	
				 	%>
			<div style="margin-left:120px" >
				共<%=cc.getTotalcount() %>条记录 <%=cc.getPageNo()%>/<%=cc.getTotalPageSize()%>页
				&nbsp;<a href="catepage.do?pageNo=1&pageSize=5" onclick="topPage()" >首页</a> 
				<a href="catepage.do?pageNo=<%=cc.getPageNo() - 1==0?cc.getPageNo():cc.getPageNo() - 1%>&pageSize=5" onclick="previousPage()">上一页</a>&nbsp;
				<a href="catepage.do?pageNo=<%=cc.getPageNo() + 1==cc.getTotalPageSize()?cc.getTotalPageSize():cc.getPageNo() +1%>&pageSize=5" onclick="nextPage()">下一页</a> 
				<a href="catepage.do?pageNo=<%=cc.getTotalPageSize()%>&pageSize=5" onclick="bottomPage()" >尾页</a>
				&nbsp;第<select onChange="if(this.value==1){location='http://localhost:8080/Message/addmsg.do?reqType=2&pageNo=1&pageSize=5'}else{location='http://localhost:8080/Message/addmsg.do?reqType=2&pageNo='+this.value+'&pageSize=5'}this.disabled='disabled'">
        <%
           if(cc!=null){
        	   int _totalPageSize=cc.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(cc.getPageNo()==(i+1)){%>
        		    	
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


</div>
</div>

</body>
</html>