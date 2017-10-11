	//商品下拉菜单
	var commodity=["商品列表","商品类型维护","商品规格属性"];
	//订单
	var indent=["待支付订单","已付款订单","已发货订单","已完成订单"];
	
	/**
		 * 鼠标事件
		 * */
		function _onmouseover(obj){
			obj.style.borderColor="gray";
		}
		
		function _onmouseout(obj){
			this.style.borderColor="#FAF8FA";
		}
		
//		_div.onclick=function(){
//			this.style.borderColor="black";
//			this.style.fontcolor="black";
//			createDiv(this);
//		//	getAId(this);
//		}
	function getAIda(object){
	var obj1=document.getElementById(object.id);
	//obj1.style.backgroundColor="gray";
}	
	
	
	 /**
    * 点击事件创建下拉菜单
    * */
   
	
function createDiv(object,arr){
	//获取div
	var div1=document.getElementById(object.id);
	
	for(var i=0;i<arr.length;i++){
    //创建下来菜单div
	    var l=30*(arr.length+1);
	    
	    div1.style.height=l+"px";
        
		var _div=document.createElement("div");
		_div.setAttribute("id","_left"+i+"ab");
		var _left_style="width: 100%;background-color:#FFFFFF"
		_div.setAttribute("style",_left_style);
		div1.appendChild(_div);
		//a标签  #A7A5AA  外边框颜色#FAF8FA
		var _div_a=document.createElement("a");
		_div_a.setAttribute("id","_left_a2"+i);
		var _div_text_style="color:#A7A5AA;font-size:15px;width: 180px;height:26px;display:block;text-align:center;line-height: 30px;"
		_div_a.setAttribute("style",_div_text_style);
		_div.appendChild(_div_a);
		//文本结点
		var _div_text=document.createTextNode(commodity1[i]);
		_div_a.appendChild(_div_text);
		
		
	}
}