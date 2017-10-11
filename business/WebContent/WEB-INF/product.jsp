<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<script type="text/javascript" src="js/commodity.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/commodity.css"/>
		<link rel="stylesheet" href="css/leftmenu.css" />
		<script type="text/javascript" src="js/onclick.js" ></script>
		<script type="text/javascript" src="js/test00.js" ></script>
		<link rel="stylesheet" href="css/show.css" />
		<link rel="stylesheet" type="text/css" href="css/cate.css"/>
		<script type="text/javascript" src="js/cate.js" ></script>

</head>
<div id="main">
			<div style="background-color: #000000;">
				<img src="img/logo.png" style="padding-top: 16px;height: 40px;width: 40px; display:inline-block;"/>
				<a style="margin:0 auto;display:inline-block;font-size: 24px;color:white ;">微电商后台管理系统</a>
				<a href="#" class="exit" id="register">注册</a>
				<a href="#" class="exit" id="login">登录</a>
			</div>
			<div id="nav">
				
				<ul>  
					<li><a href="#">首页</a></li>
			        <li><a href="#">商品</a>
			        	<ul>  
			                <li><a href="#"  onclick="testo00()">商品列表</a></li>  
			                <li><a href="#"  onclick="createCate()">商品分类</a></li>  
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
						            <a href='#'>商品列表</a>
						            <a href="cate.jsp" >商品类别维护</a>
						            
						            <a href='#' onclick="_shangpinguigeshuxing()"> 商品规格属性</a>
						            
						            
						          </div>
						        </li>
						    
								<li>
						          <h4 class="M4" id="dingdan" onclick="" ><span></span>订单管理</h4>
						          <div class="list-item none" id="" style="height: 0;">
						            <a href='#'onclick="">待支付订单</a>
						            <a href='#'onclick="">已付款订单</a>
						            <a href='#'onclick="">已发货订单</a>
						            <a href="#" >已完成订单</a>
						          </div>
						        </li>
							
						        </li>
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
	      <!-- 商品列表 -->
			 <div >
			<form action="/" method="get" id="show"  >
				<div class="change_div_1_class" id="change_div_1_id">
				    <a  class="change_div_1_" id="change_div_add"  >添加</a>
				    <a class="change_div_1_" id="change_div_delete" >删除</a>
				    <a class="change_div_1_" id="change_div_re">回收</a>
					<a class="change_div_1_" id="change_div_re">添加</a>
				   <a class="change_div_1_" id="change_div_search">搜索</a>
				</div>
				<div class="div_1_" id="div_1-input0">
				    <input class="div_1_input" id="div1_input0" type="checkbox" onlick="">
				 	<div class="div_1_number" id="div_1_number0">编号</div>
				 	<div class="div_1_number1" id="div_1_number0">货号</div>
				 	<div class="div_1_name" id="div_1_number0">名称</div>
				 	<div class="div_1_stock" id="div_1_number0">类别</div>
				 	<div class="div_1_grounding" id="div_1_number0">价格</div>
				 	<div class="div_1_update" id="div_1_update">修改</div>
				 	<div class="div_1_delete" id="div_1_delete">删除</div>
				</div>	

				 <%
					 ProductDao pro=new ProductDaoImpl();
	         		 PageModel<Product> pp=   pro.getPageModel(1, 5);
	              
              
          
              for(int j=0;j<pp.getDatas().size();j++){
            	  %>
				    
				 	
				 	<div class="div_1_" id="div_1-input<%=j%>">
				    <input class="div_c_input" id="div1_input<%=j%>" type="checkbox" name="div1_input<%=j%> " > 

				 	<div class="div_1_number" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getCid() %></div>
				 	<div class="div_1_number1" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPno() %></div>
				 	<div class="div_1_name" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPname() %></div>
				 	<div class="div_1_stock" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getCid() %></div>
				 	<div class="div_1_grounding" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPrice() %> </div>
	            	 
				 	<div class="div_1_update" id="div_1_update">修改</div>
				 	<div class="div_1_delete" id="div_1_delete"   >删除</div>
				   </div>
				 	<%} %>
				
			</form>
			</div>
			
			
			
			
		</div>
	</div>
</div>
	</body>
</html>