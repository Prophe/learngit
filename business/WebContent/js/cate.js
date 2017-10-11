var cate=[{"cid":"编号","cname":"类别名称","pid":"上级分类","update":"修改","delete":"删除"},
		  {"cid":"1","cname":"男装","pid":"无","update":"点击修改","delete":"点击删除"}];


function createCate(){
	//找到名为right的div
	var cate_div=document.getElementById("right");
	
	cate_div.innerHTML="";
if(cate_div.style.display.match("none")){
		cate_div.style.display="block";
	}else if(cate_div.style.display.match("block")){
		cate_div.style.display.match("none");
	}
//	if(cate_div_1.style.display.match("none")){
//		cate_div_1.style.display="block";
//	}else if(cate_div_1.style.display.match("block")){
//		cate_div_1.style.display.match("none");
//	}
	/*解决了无限建造的问题*/
//	main.innerHTML="";
	//为其添加：添加，删除，回收站的按钮在一个div中
	var cate_div_1=document.createElement("div");
	//设置类名与id
	cate_div_1.setAttribute("class","cate_div_c_class");
	cate_div_1.setAttribute("id","cate_div_c_id");
	//将其追加到change中去
	cate_div.appendChild(cate_div_1);
	
	
	//添加：添加按钮
	var cate_div_1_add=document.createElement("button");
	//给添加按钮设置属性
	cate_div_1_add.setAttribute("class","cate_div_c_");
	cate_div_1_add.setAttribute("id","cate_div_c_add");
	cate_div_1_add.setAttribute("onclick","cateadd()");
	//追加添加的文本
	var cate_div_1_add_text=document.createTextNode("添加");
	cate_div_1_add.appendChild(cate_div_1_add_text);
	cate_div_1.appendChild(cate_div_1_add);
	
	//添加：修改按钮
	var cate_div_1_update=document.createElement("button");
	//给添加按钮设置属性
	cate_div_1_update.setAttribute("class","cate_div_c_");
	cate_div_1_update.setAttribute("id","cate_div_c_update");
	cate_div_1_update.setAttribute("onclick","cateupdate()");
	//追加添加的文本
	var cate_div_1_update_text=document.createTextNode("修改");
	cate_div_1_update.appendChild(cate_div_1_update_text);
	cate_div_1.appendChild(cate_div_1_update);
	
	//添加：删除按钮
	var cate_div_1_delete=document.createElement("button");
	//给删除按钮设置属性
	cate_div_1_delete.setAttribute("class","cate_div_c_");
	cate_div_1_delete.setAttribute("id","cate_div_c_delete")
	cate_div_1_delete.setAttribute("onclick","catedelete()");
	//追加删除的文本
	var cate_div_1_delete_text=document.createTextNode("删除");
	cate_div_1_delete.appendChild(cate_div_1_delete_text);
	cate_div_1.appendChild(cate_div_1_delete);
	
	//添加：回收站按钮
	var cate_div_1_re=document.createElement("button");
	//给删除按钮设置属性
	cate_div_1_re.setAttribute("class","cate_div_c_");
	cate_div_1_re.setAttribute("id","cate_div_c_re");
	cate_div_1_re.setAttribute("onclick","catere()");
	//追加删除的文本
	var cate_div_1_re_text=document.createTextNode("回收站");
	cate_div_1_re.appendChild(cate_div_1_re_text);
	cate_div_1.appendChild(cate_div_1_re);
	
	//添加搜索框
	var cate_div_1_input=document.createElement("input");
	//给搜索框添加属性
	cate_div_1_input.setAttribute("class","cate_div_c_input");
	cate_div_1_input.setAttribute("id","cate_div_c_input");
	cate_div_1_input.setAttribute("placeholder","  商品编号/名称");
	//将搜索框追加
	cate_div_1.appendChild(cate_div_1_input);
	
	
	
	//添加：搜索按钮cate_div_1_search cate_div_1_search
	var cate_div_1_search=document.createElement("button");
	//给搜索按钮设置属性
	cate_div_1_search.setAttribute("class","cate_div_c_search");
	cate_div_1_search.setAttribute("id","cate_div_c_search");
	cate_div_1_search.setAttribute("onclick","catesearch()");
	//追加搜索的文本
	var cate_div_1_search_text=document.createTextNode("搜索");
	cate_div_1_search.appendChild(cate_div_1_search_text);
	cate_div_1.appendChild(cate_div_1_search);
	
		for(var i=0;i<cate.length;i++){
		//在change的div中创建新的div并追加
		var div_1=document.createElement("div");
		//给新的div类名与id
		div_1.setAttribute("class","div_c_");
		div_1.setAttribute("id","div_c_"+i);
		//将新的div追加到change中
		cate_div.appendChild(div_1);
		
		//创建一个复选框
		var checkbox=document.createElement("input");
		//给复选框设置类名与id
		checkbox.setAttribute("class","div_c_input");
		checkbox.setAttribute("id","div_c_input"+i);
		//给复选框设置属性
		checkbox.setAttribute("type","checkbox");
		//追加
		div_1.appendChild(checkbox);
		
		//创建编号的div
		var number=document.createElement("div");
		//给编号设置类名与id
		number.setAttribute("class","div_c_number");
		number.setAttribute("id","div_c_number"+i);
		
		//将其追加到div_1中
		div_1.appendChild(number);
		
		//创建number的文本节点
		var div_1_number_text=document.createTextNode(cate[i].cid);
		//将文本节点追加到number中
		number.appendChild(div_1_number_text);
	
	  //创建名称的div
		var name=document.createElement("div");
		//给名称设置类名与id
		name.setAttribute("class","div_c_name");
		name.setAttribute("id","div_c_name"+i);
		
		//将其追加到div_1中
		div_1.appendChild(name);
		
		//创建number的文本节点
		var div_1_name_text=document.createTextNode(cate[i].cname);
		//将文本节点追加到number中
		name.appendChild(div_1_name_text);
	
	//上层类别的div
		var stock=document.createElement("div");
		//给名称设置类名与id
		stock.setAttribute("class","div_c_stock");
		stock.setAttribute("id","div_c_stock"+i);
		
		//将其追加到div_1中
		div_1.appendChild(stock);
		
		//创建number的文本节点
		var div_1_stock_text=document.createTextNode(cate[i].pid);
		//将文本节点追加到number中
		stock.appendChild(div_1_stock_text);
	
	//创建修改操作的div
		var operate=document.createElement("div");
		//给名称设置类名与id
		operate.setAttribute("class","div_c_update");
		operate.setAttribute("id","div_c_update"+i);
		
		//将其追加到div_1中
		div_1.appendChild(operate);
		
		//创建number的文本节点
		var div_1_operate_text=document.createTextNode(cate[i].update);
		//将文本节点追加到number中
		operate.appendChild(div_1_operate_text);
	
	//创建删除操作的div
		var operate=document.createElement("div");
		//给名称设置类名与id
		operate.setAttribute("class","div_c_delete");
		operate.setAttribute("id","div_c_delete"+i);
		
		//将其追加到div_1中
		div_1.appendChild(operate);
		
		//创建number的文本节点
		var div_1_operate_text=document.createTextNode(cate[i].delete);
		//将文本节点追加到number中
		operate.appendChild(div_1_operate_text);
	
	
	}
		
	
	
}		

function cateadd(){
	
	
	var cate_add_div=document.getElementById("cateadd");
	if(cate_add_div.style.zIndex.match("-1")){
		cate_add_div.style.display="2";
		
		
		
	}else if(cate_add_div.style.zIndex.match("2")){
		cate_add_div.style.zIndex.match("-1");
	}
}