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
		<link rel="stylesheet" href="css/show.css" />
		

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
	   
		<!-- 商品列表 -->
			 <div >
			<form action="/" method="get" id="show"  >
				<div class="change_div_1_class" id="change_div_1_id">
				    <a href="proadd.jsp">添加</a>
				    <button class="change_div_1_" id="change_div_delete" ><a onclick="openChild(this)">删除</a></button>
				    <button class="change_div_1_" id="change_div_re"><a>回收</a></button>
					<button class="change_div_1_" id="change_div_re"><a>修改</a></button>
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
  
				 	
				 	
				 	<form>
				  <div class="div_1_" id="div_1-input<%=j%>">
				    <input class="div_1_input" id="div1_input<%=j%>" type="checkbox" onlick="">
				 	<div class="div_1_number" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getId() %></div>
				 	<div class="div_1_number1" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPno() %></div>
				 	<div class="div_1_name" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPname() %></div>
				 	<div class="div_1_photo" id="div_1_number<%=j%>"><img style="width:61px;height:61px;" src="img/<%=pp.getDatas().get(j).getPic() %>"/></div>
				 	<div class="div_1_stock" id="div_1_number<%=j%>"><%=cate%></div>
				 	<div class="div_1_grounding" id="div_1_number<%=j%>"><%=pp.getDatas().get(j).getPrice() %></div>
				 	<div class="div_1_grounding1" id="div_1_number<%=j%>"><%=online%></div>
				 	<div class="div_1_update" id="div_1_update"><a href="Proup.do?Id=<%=pp.getDatas().get(j).getId() %>&update=1"/>修改</a></div>
				 	<div class="div_1_delete" id="div_1_delete"><a href="prodele.do?Id=<%=pp.getDatas().get(j).getId() %>"/>删除</a></div>
				</div>	
				    </form>
				 	<%}
				 	
				 	%>
			<div style="margin-left:120px" >
				共<%=pp.getTotalcount() %>条记录 <%=pp.getPageNo()%>/<%=pp.getTotalPageSize()%>页
				&nbsp;<a href="Propage.do?pageNo=1&pageSize=5" onclick="topPage()" >首页</a> 
				<a href="Propage.do?pageNo=<%=pp.getPageNo() - 1==0?pp.getPageNo():pp.getPageNo() - 1%>&pageSize=5" onclick="previousPage()">上一页</a>&nbsp;
				<a href="Propage.do?pageNo=<%=pp.getPageNo() + 1==pp.getTotalPageSize()?pp.getTotalPageSize():pp.getPageNo() +1%>&pageSize=5" onclick="nextPage()">下一页</a> 
				<a href="Propage.do?pageNo=<%=pp.getTotalPageSize()%>&pageSize=5"  >尾页</a>
				&nbsp;第<select onChange="if(this.value==1){location='http://localhost:8080/business/Propage.do?reqType=2&pageNo=1&pageSize=5'}else{location='http://localhost:8080/Message/Propage.do?pageNo='+this.value+'&pageSize=5'}this.disabled='disabled'">
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
			
			
			
	  
		
		</div>
	</div>
</div>
	</body>
</html>