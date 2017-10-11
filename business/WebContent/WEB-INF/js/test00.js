
var change=[{"number":"编号","name":"名称","stock":"库存","grounding":"上架","sort":"排序","operate":"操作"},
{"number":"19","name":"好金鱼一条","stock":"9","grounding":"是","sort":"1","operate":"修改|删除"},
{"number":"25","name":"你猜","stock":"8","grounding":"是","sort":"3","operate":"修改|删除"},
{"number":"96","name":"小水槽","stock":"1109","grounding":"是","sort":"10","operate":"修改|删除"},
{"number":"95","name":"大龙鱼","stock":"198","grounding":"是","sort":"10","operate":"修改|删除"},
{"number":"93","name":"清洁虾","stock":"85","grounding":"是","sort":"10","operate":"修改|删除"},
{"number":"92","name":"蓝蓟寄居蟹","stock":"80","grounding":"是","sort":"10","operate":"修改|删除"},
{"number":"91","name":"石美人","stock":"61","grounding":"否","sort":"10","operate":"修改|删除"},
{"number":"90","name":"大西洋蓝调","stock":"887","grounding":"是","sort":"10","operate":"修改|删除"}];

var img=["","0.jpg","0.jpg","0.jpg","0.jpg","0.jpg","0.jpg","0.jpg","0.jpg"]

function testo00(){
	//找到名为change的div
	var change_div=document.getElementById("right");
	//为其添加：添加，删除，回收站的按钮在一个div中
	
	change_div.innerHTML="";
	if(change_div.style.display.match("none")){
		change_div.style.display="block";
	}else if(change_div.style.display.match("block")){
		change_div.style.display.match("none");
	}
	
	var change_div_1=document.createElement("div");
	//设置类名与id
	change_div_1.setAttribute("class","change_div_1_class");
	change_div_1.setAttribute("id","change_div_1_id");
	//将其追加到change中去
	change_div.appendChild(change_div_1);
	
	
	//添加：添加按钮
	var change_div_1_add=document.createElement("button");
	//给添加按钮设置属性
	change_div_1_add.setAttribute("class","change_div_1_");
	change_div_1_add.setAttribute("id","change_div_1_add");
	change_div_1_add.setAttribute("onclick","testadd()");
	//追加添加的文本
	var change_div_1_add_text=document.createTextNode("添加");
	change_div_1_add.appendChild(change_div_1_add_text);
	change_div_1.appendChild(change_div_1_add);
	
	
	//添加：删除按钮
	var change_div_1_delete=document.createElement("button");
	//给删除按钮设置属性
	change_div_1_delete.setAttribute("class","change_div_1_");
	change_div_1_delete.setAttribute("id","change_div_1_delete")
	change_div_1_delete.setAttribute("onclick","testdelete()");
	//追加删除的文本
	var change_div_1_delete_text=document.createTextNode("删除");
	change_div_1_delete.appendChild(change_div_1_delete_text);
	change_div_1.appendChild(change_div_1_delete);
	
	//添加：回收站按钮
	var change_div_1_re=document.createElement("button");
	//给删除按钮设置属性
	change_div_1_re.setAttribute("class","change_div_1_");
	change_div_1_re.setAttribute("id","change_div_1_re");
	change_div_1_re.setAttribute("onclick","testre()");
	//追加删除的文本
	var change_div_1_re_text=document.createTextNode("回收站");
	change_div_1_re.appendChild(change_div_1_re_text);
	change_div_1.appendChild(change_div_1_re);
	
	//添加搜索框
	var change_div_1_input=document.createElement("input");
	//给搜索框添加属性
	change_div_1_input.setAttribute("class","change_div_1_input");
	change_div_1_input.setAttribute("id","change_div_1_input");
	change_div_1_input.setAttribute("placeholder","  商品编号/名称");
	//将搜索框追加
	change_div_1.appendChild(change_div_1_input);
	
	//添加：搜索按钮
	var change_div_1_search=document.createElement("button");
	//给搜索按钮设置属性
	change_div_1_search.setAttribute("class","change_div_1_search");
	change_div_1_search.setAttribute("id","change_div_1_search");
	change_div_1_re.setAttribute("onclick","testsearch()");
	//追加搜索的文本
	var change_div_1_re_text=document.createTextNode("搜索");
	change_div_1_search.appendChild(change_div_1_re_text);
	change_div_1.appendChild(change_div_1_search);
	
	
	for(var i=0;i<change.length;i++){
		//在change的div中创建新的div并追加
		var div_1=document.createElement("div");
		//给新的div类名与id
		div_1.setAttribute("class","div_1_");
		div_1.setAttribute("id","div_1_"+i);
		//将新的div追加到change中
		change_div.appendChild(div_1);
		
		//创建一个复选框
		var checkbox=document.createElement("input");
		//给复选框设置类名与id
		checkbox.setAttribute("class","div_1_input");
		checkbox.setAttribute("id","div_1_input"+i);
		//给复选框设置属性
		checkbox.setAttribute("type","checkbox");
		//追加
		div_1.appendChild(checkbox);
		
		//创建编号的div
		var number=document.createElement("div");
		//给编号设置类名与id
		number.setAttribute("class","div_1_number");
		number.setAttribute("id","div_1_number"+i);
		
		//将其追加到div_1中
		div_1.appendChild(number);
		
		//创建number的文本节点
		var div_1_number_text=document.createTextNode(change[i].number);
		//将文本节点追加到number中
		number.appendChild(div_1_number_text);
	
		
		
		//创建名称的div
		var name=document.createElement("div");
		//给名称设置类名与id
		name.setAttribute("class","div_1_name");
		name.setAttribute("id","div_1_name"+i);
		
		//将其追加到div_1中
		div_1.appendChild(name);
		
		//创建number的文本节点
		var div_1_name_text=document.createTextNode(change[i].name);
		//将文本节点追加到number中
		name.appendChild(div_1_name_text);
		
		
		//创建库存的div
		var stock=document.createElement("div");
		//给名称设置类名与id
		stock.setAttribute("class","div_1_stock");
		stock.setAttribute("id","div_1_stock"+i);
		
		//将其追加到div_1中
		div_1.appendChild(stock);
		
		//创建number的文本节点
		var div_1_stock_text=document.createTextNode(change[i].stock);
		//将文本节点追加到number中
		stock.appendChild(div_1_stock_text);
		
		
		
		//创建上架的div
		var grounding=document.createElement("div");
		//给名称设置类名与id
		grounding.setAttribute("class","div_1_grounding");
		grounding.setAttribute("id","div_1_grounding"+i);
		
		//将其追加到div_1中
		div_1.appendChild(grounding);
		
		//创建number的文本节点
		var div_1_grounding_text=document.createTextNode(change[i].grounding);
		//将文本节点追加到number中
		grounding.appendChild(div_1_grounding_text);
		
		
		
		//创建排序的div
		var sort=document.createElement("div");
		//给名称设置类名与id
		sort.setAttribute("class","div_1_sort");
		sort.setAttribute("id","div_1_sort"+i);
		
		//将其追加到div_1中
		div_1.appendChild(sort);
		
		//创建number的文本节点
		var div_1_sort_text=document.createTextNode(change[i].sort);
		//将文本节点追加到number中
		sort.appendChild(div_1_sort_text);
		
		
		
		
		//创建操作的div
		var operate=document.createElement("div");
		//给名称设置类名与id
		operate.setAttribute("class","div_1_operate");
		operate.setAttribute("id","div_1_operate"+i);
		
		//将其追加到div_1中
		div_1.appendChild(operate);
		
		//创建number的文本节点
		var div_1_operate_text=document.createTextNode(change[i].operate);
		//将文本节点追加到number中
		operate.appendChild(div_1_operate_text);
	}
	
	var div_1_input0=document.getElementById("div_1_input0");
	div_1_input0.setAttribute("onclick","div_1_input0_onclick()");
}

function div_1_input0_onclick(){
	var sa=document.getElementById("div_1_input0");
	var box1=document.getElementsByClassName("div_1_input");
	if(sa.checked==true){
		for(var k=1;k<box1.length;k++){
			box1[k].checked=true;
		}
	}else{
		for(var k=1;k<box1.length;k++){
			box1[k].checked=false;
		}
	}
}
