<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.*,com.neusoft.entity.*,com.neusoft.Dao.*,com.neusoft.Dao.Impl.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品分类</title>
<script type="text/javascript" src="js/commodity.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/commodity.css"/>
		<link rel="stylesheet" href="css/leftmenu.css" />
		<link rel="stylesheet" href="css/change.css" />
		<link rel="stylesheet" type="text/css" href="css/cate.css"/>
		<script type="text/javascript" src="js/onclick.js" ></script>
		<script type="text/javascript" src="js/test00.js" ></script>
		<script type="text/javascript" src="js/cate.js" ></script>
	</head>
	<body>
		<div id="main">
			<div style="background-color: #000000;">
				<img src="img/logo.png" style="padding-top: 16px;height: 40px;width: 40px; display:inline-block;"/>
				<a style="margin:0 auto;display:inline-block;font-size: 24px;color:white ;">微电商后台管理系统</a>
				<a href="#" id="exit">退出</a>
			</div>
			<div id="nav">
				
				<ul>  
					<li><a href="#">首页</a></li>
			        <li><a href="#">商品</a>
			        	<ul>  
			                <li><a href="#" onclick="testo00()">商品列表</a></li>  
			                <li><a href="#" " >商品分类</a></li>  
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
						            <a href='#' onclick="testo00()">商品列表</a>
						            <a href="#" onclick="createCate()">商品类别维护</a>
						            
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
		<div id="cateadd"  style="border:1px solid palevioletred;height: 0px;width: 400px; position: absolute;left: 32%;;">
					<form action="addcate.do?reqType=1" method="post" >
					
							<tr ><h1>添加分类</h1></tr>
							<tr><span style="margin-left:12px;width:300px;">分类名称<input type="text" name="cname" style="width: 300px"  /></span></tr>
							<tr style="display: block;" >
						 		<td> 
								 <span style="margin-left:12px;width:300px;overflow:hidden;" > 
						            上级分类<select style="width:300px;height:25px"  id="SS" name="pname"> 
						            
						           <%--<c:forEach begin="1" end=${PList.size() }></c:forEach> --%>
						           <option value="">请选择父类别</option>   
						           <%  CateDao s=new CateDaoImpl();
						                List<Cate> list=s.getCatList();
						                for (Cate cate : list) {
						                	%><option value="<%=cate.getCname()%>"><%=cate.getCname() %></option>  <% 
						        		}
						           %>
						            </select> 
						         </span> 
								</td>
							</tr>
							<tr><p><input type="submit" name="btnSave" value="保存" /><input type="submit" name="btnSave" value="返回" /></p></tr>
						
					</form>
				
			</div>
		
		
		</div>



</body>
</html>