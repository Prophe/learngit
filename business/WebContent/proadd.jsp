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
						            <a  title="goods。jsp" onclick="handover(this)" href='Propage.do' >商品列表</a>
						            <a href="catepage.do" >商品类别维护</a>
						            
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
		
		<!--
        	/*
	 * id         -- 商品编号，主键
   pname       -- 商品名称
   cid         -- 外键，引用自cate表中的cid 商品类别
   pno         -- 货号
   pic         -- 商品图片
   price        -- 商品价格
   online      -- 1:上线  0:下线 
   pdetail     -- 商品详情

	   id,pname,cid,pno,pic,price,online,pdetail
   **/
	
        -->
				<form action="proadd.do" method="post">
			<table class="tb">
				<tr>
					<td class="td_left">商品名称</td>
					<td><input class="_input" name="pro_name" type="text"/></td>
				</tr>
			
				<tr>
					<td class="td_left">商品类别</td>
					<td>
						<select name="type" id="region" onchange="selectProv(this)">
						
							<option>请选择类别</option>
				       <%  CateDao s=new CateDaoImpl();
						        List<Cate> list=s.getAllCatList();
						           for (Cate cate : list) {
						           	%><option value="<%=cate.getCname()%>"><%=cate.getCname() %></option>  <% 
						        		}
						           %>
					
				
				           

							</select>
					</td>
				</tr>
				
				<tr>
					<td class="td_left">货号</td>
					<td><input class="_input" name="pro_no" type="text" /></td>
				</tr>
				
				<tr>
					<td class="td_left">规格</td>
					<td>
						<select name="pro_spec">
							<option>衣服尺码</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="td_left">上传照片</td>
					<td><input type="file" name="pro_img_src" value="上传照片" /></td>
				</tr>
				
				<tr>
					<td class="td_left">商品价格</td>
					<td><input class="_input" name="pro_price" type="text" /></td>
				</tr>
				
				<tr>
					<td class="td_left">是否上线</td>
					<td><input name="pro_sx" value="1" type="radio" />是<input name="pro_sx" value="0" type="radio" />否</td>
				</tr>
				
				<tr>
					<td class="td_left_last">商品详情</td>
					<td>
					
						<textarea id="edit" name="edit" ></textarea>
						
					</td>
				</tr>
			</table>
			<input type="submit" name="btnSave" value="保存" />
		</form>
	</body>
	</html>