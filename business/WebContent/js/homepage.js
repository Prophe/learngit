//导航栏
var welcome=["admin","管理员"];
//左边的菜单
var commodity=["商品列表","订单管理","前台管理","权限管理","会员管理","系统设置"];
//商品管理下拉菜单
var commodity1=["商品列表","商品类型维护","商品规格属性"];
var _li=[[{"content":"商品列表","link":"index.html"},{"content":"商品类别维护","link":"index.html"},{"content":"商品规格属性","link":"index.html"}],
[{"content":"增加订单","link":"index.html"},{"content":"删除订单","link":"index.html"},{"content":"修改订单","link":"index.html"},{"content":"查询订单","link":"index.html"}]];


function _onload(){
    var _body=document.getElementsByTagName("body")[0];
    //主div  var _div=document.createElement("div");
    /**
	 * 主div _main
 	 * */
    var _main=document.createElement("div");
//  var _main=document.createElemrnt("div");

    _main.setAttribute("id","main");
//  _main_style="width: 100%;height: 40px;  border: 1px solid palegreen;background-color: paleturquoise;";
    _body.appendChild(_main);
    
    //导航栏div _header
    var _header= document.createElement("div");
    _header.setAttribute("id","header");
    var _header_style="height: 40px;border: 1px solid royalblue;background-color: #008CC7;"
    _header.setAttribute("style",_header_style);
    _main.appendChild(_header);
    //导航栏里的文字  h1 h2/
    /**
     * var _day_date=document.createTextNode(_new_date.getDate());
		_day_p.appendChild(_day_date);
		_div.appendChild(_day_p);
     * **/
    var he1=document.createElement("h");
//  h1.setAttribute("id","he1");
    var he1_text_style="color: white;font-size:25px;"
    he1.setAttribute("style",he1_text_style);
    _header.appendChild(he1);
    //a1文本结点（用户名）
    var he1_text=document.createTextNode("欢迎       ");
    he1.appendChild(he1_text);
    //a2
    var he2=document.createElement("a");
    var he2_text_style="font: '微软雅黑';color: red;font-size:20px;"
    he2.setAttribute("style",he2_text_style);
    _header.appendChild(he2);
    //a2文本结点
    var he2_text=document.createTextNode(welcome[0]);
    
    he2.appendChild(he2_text);
    //a3（权限等级）
    var he3=document.createElement("a");
    var he3_text_style="color: white;font-size:23px;"
    he3.setAttribute("style",he3_text_style);
    _header.appendChild(he3);
    //a3文本结点（权限等级）
    var he3_text=document.createTextNode("登录     网店后台管理系统");
    he3.appendChild(he3_text);
    //a4（权限等级）
    var he4=document.createElement("a");
    var he4_text_style="color: white;font-size:23px;float:right;margin-right:31px;"
    he4.setAttribute("style",he4_text_style);
    _header.appendChild(he4);
    //a4文本结点（权限等级）
    var he4_text=document.createTextNode(welcome[1]);
    he4.appendChild(he4_text);
  /**
   * 左边的div块
   * 
   * **/
    var _left=document.createElement("div");
    _left.setAttribute("id","_left");
    _left_style="width: 180px;height: 580px;background-color:#FAF8FA;margin:5px;"
    _left.setAttribute("style",_left_style);
     _main.appendChild(_left);
     
     /**
      * 在左边的div中加一级菜单
      *  commodity=["商品列表","订单管理","前台管理","权限管理","会员管理","系统设置"]
      * **/
     
	//找到大的div
	 var div_big=document.getElementById("_left");
	 for(var i=0;i<commodity.length;i++){
	 	//将一级菜单追加到大的div中
	 	var div_ul=document.createElement("div");
	 	//给一级菜单设置类名与id
	 	div_ul.setAttribute("class","div_ul_class");
	 	div_ul.setAttribute("id","div_ul"+i);
	 	//给一级菜单添加样式
	 	var div_ul_style="width: 100%;height: 40px;border: 1px solid #FAF8FA;";
	 	div_ul.setAttribute("style",div_ul_style);
	 	//给一级菜单添加 onclick
	 	div_ul.setAttribute("onclick","testt("+i+")")
	    //将一级菜单添加进大的div中去
	    div_big.appendChild(div_ul);
	    
	    
	    //将一级菜单的文本的追加
	    var div_ul_text=document.createTextNode(commodity[i]);
	    div_ul.appendChild(div_ul_text);
	    
	    
	    //将二级菜单追加到一级菜单
	    //创建一个二级菜单
	    var div_li=document.createElement("div");
	    //给二级菜单设置类名与id
	    div_li.setAttribute("class","div_li_calss");
	    div_li.setAttribute("id","div_li"+i);
	    //给二级菜单添加样式，高度为0；
	    //var div_li_style="height=0px;width: 200px;overflow: hidden;border:1px solid green;";
	    //将样式追加到二级菜单中
	    div_li.setAttribute("style","height=0px;overflow: hidden;");
	    //将二级菜单追加到大的div上
	    div_big.appendChild(div_li);
	    
	    
	    //给二级菜单追加文本内容
	    for(var j=0;j<_li[i].length;j++){
	    	//创建二级菜单的每个菜单
	    	var div_li_=document.createElement("div");
	    	//给每个菜单设置类名和id
	    	div_li_.setAttribute("class","div_li_1");
	    	//每个二级菜单在a标签里面
	    	var div_li_div=document.createElement("div");
	    	//给每个二级菜单设置href属性
	    	//div_li_a.setAttribute("onclick",_li[i][j].link);
	    	div_li_div.setAttribute("onclick","testo"+i+j+"()");
	    	//并将其追加到二级菜单当中去
	    	div_li_.appendChild(div_li_div);
	    	div_li.appendChild(div_li_);
	    	//给每个小菜单添加文本内容
	    	var div_li_text=document.createTextNode(_li[i][j].content);
	    	//将文本内容追加到小菜单当中去
	    	div_li_div.appendChild(div_li_text);
	    	
	    }
	   //判断二级菜单的长度是否为0
	    var div_li_0=document.getElementById("div_li"+i);
		var h=div_li_0.offsetHeight;
	    if(h!=0){
	    	var style2="height:0px;overflow:hidden";
			div_li_0.setAttribute("style",style2);
	    }
	 
	} 
}

//	function testt(i){
//		var div_li_0=document.getElementById("div_li"+i);
//		var h=div_li_0.offsetHeight;
//		if(h==0){
//			var style1="height:"+(_li[i].length+1)*30+"px;";
//			div_li_0.setAttribute("style",style1);
//		}else{
//			var style2="height:0px;overflow:hidden";
//			div_li_0.setAttribute("style",style2);
//		}
//	}

     
     
     
     /**
      * 
      * 我自己的**/
//	for(var i=0;i<commodity.length;i++){
//		//装每级菜单的div块
//		var div=document.createElement("div");
//		div.setAttribute("id","_left"+i+"a");
//		var _div_style="width: 178px;border: 1px solid #FAF8FA;";
//		div.setAttribute("style",_div_style);
//		_left.appendChild(div);
//	  //每个一级菜单块
//		var _div=document.createElement("div");
//		_div.setAttribute("id","_left"+i);
//		var _left_style="width: 100%;height: 40px;border: 1px solid #FAF8FA;float:";
//		_div.setAttribute("style",_left_style);
//		div.appendChild(_div);
//		//a标签  #A7A5AA  外边框颜色#FAF8FA
//		var _div_a=document.createElement("a");
//		_div_a.setAttribute("id","_left_a1"+i);
//		var _div_text_style="color:#A7A5AA;font-size:18px;width: 180px;height: 40px;display:block;text-align:center;line-height: 40px;"
//		_div_a.setAttribute("style",_div_text_style);
//		_div.appendChild(_div_a);
//		//文本结点
//		var _div_text=document.createTextNode(commodity[i]);
//		_div_a.appendChild(_div_text);
//		
//		/**
//		 * 鼠标事件
//		 * */
//		_div.onmouseover=function(){
//			this.style.borderColor="gray";
//			getAIda(this);
//		}
//		
//		_div.onmouseout=function(){
//			this.style.borderColor="#FAF8FA";
//			getAIda(this);
//		}
//		
//		_div.onclick=function(){
//			this.style.borderColor="black";
//			this.style.fontcolor="black";
//			createDiv(this);
//		//	getAId(this);
//		}
////for 循环后括号		
//	}
//
//	/**
//	 * 获取该id
//	 * */
//function getAIda(object){
//	var obj1=document.getElementById(object.id+"b");
//	//obj1.style.backgroundColor="gray";
//}	
// /**
//  * 点击事件创建下拉菜单
//  * */
//	
//function createDiv(object){
//	//获取div
//	var div1=document.getElementById(object.id);
//	
//	for(var i=0;i<commodity1.length;i++){
//  //创建下来菜单div
//	    var l=30*(commodity1.length+1);
//	    
//	    div1.style.height=l+"px";
//      
//		var _div=document.createElement("div");
//		_div.setAttribute("id","_left"+i+"ab");
//		var _left_style="width: 100%;background-color:#FFFFFF"
//		_div.setAttribute("style",_left_style);
//		div1.appendChild(_div);
//		//a标签  #A7A5AA  外边框颜色#FAF8FA
//		var _div_a=document.createElement("a");
//		_div_a.setAttribute("id","_left_a2"+i);
//		var _div_text_style="color:#A7A5AA;font-size:15px;width: 180px;height:26px;display:block;text-align:center;line-height: 30px;"
//		_div_a.setAttribute("style",_div_text_style);
//		_div.appendChild(_div_a);
//		//文本结点
//		var _div_text=document.createTextNode(commodity1[i]);
//		_div_a.appendChild(_div_text);
//		
//		
//		/**
//		 * 鼠标事件
//		 * */
//		_div.onmouseover=function(){
//			this.style.borderColor="gray";
//			getAIdb(this);
//		}
//		
//		_div.onmouseout=function(){
//			this.style.borderColor="#FAF8FA";
//			getAIdb(this);
//		}
//		
//	}
//	
//	
//}
//
///**
//	 * 获取该id b
//	 * */
//function getAIdb(object){
//	var obj1=document.getElementById(object.id+"b");
//	//obj1.style.backgroundColor="gray";
//}	
