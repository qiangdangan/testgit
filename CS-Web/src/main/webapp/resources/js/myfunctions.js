/* 中文UTF-8 */

/*
交互效果功能，封装的一些方法，提供给程序员调用。
*/

/*
函数名称：WindowTimeoutResize()
创建时间：20216-08-04
实现功能：触发窗体 resize 事件
*/
function WindowTimeoutResize(){
	setTimeout(function(){
		$(window).resize();
	},210);
}

/*
函数名称：TipsFrame.close(),  TipsFrame.open()
创建时间：20216-08-01
实现功能：关闭|打开 右侧温馨提示框
*/
var TipsFrame = {
	close:function(){
		$(".div-rightside:eq(0)").removeClass("show-tips-frame");
	},
	open:function(){
		$(".div-rightside:eq(0)").addClass("show-tips-frame");
	}
}


/*
函数名称：ModalWindow.close(),  ModalWindow.open()
创建时间：20216-08-01
实现功能：关闭|打开 模态窗口

var ModalWindow = {
	close:function(divID){
		$("body").removeClass("modal-open");
		$("#" +divID).removeClass("in");
		$(".modal-backdrop:last").removeClass("in");
		setTimeout(function(){
			$("#" +divID).hide();
			$(".modal-backdrop:last").remove();
		},150);
	},
	open:function(divID){
		$("body").addClass("modal-open");
		$("#" +divID).css({"display":"block"});
		$("body").append("<div class='modal-backdrop fade in'></div>");
		var $modalDialog = $("#" +divID).find(".modal-dialog:eq(0)");
		var $winWidth = $(window).width();
		$modalDialog.css({left:(($winWidth - $modalDialog.width())/2),top:'50px'});
		var handleID = divID + "_handle";
		$modalDialog.find(".modal-header:eq(0)").attr("id",handleID);
		//使它能够拖放
		$modalDialog.draggable({ "handle":"#"+handleID });
		setTimeout(function(){
			$("#" +divID).addClass("in");
		});
	}
}*/

/*
函数名称：LeftNav.toggle()
创建时间：20216-08-02
实现功能：关闭|打开 左侧栏
*/
var LeftNav = {
	toggle:function(){
		var $body = $("body:eq(0)");
		if ($body.hasClass("body-full-mode"))
		{
			$body.removeClass("body-full-mode");
		}else{
			$body.addClass("body-full-mode");
		}
		
		WindowTimeoutResize();
	}
}


/*
函数名称：AddPanel.toggle()
创建时间：20216-08-03
实现功能：关闭|打开 分块加减行
参　　数：按钮自身 this
*/
var AddPanel = {
	toggle:function(element){
		var $group = $(element).parent().parent();
		var $switchText = $group.find(".switch-text:eq(0)");
		var $switchInput = $group.find(".switch-input:eq(0)");
		if ($switchText.is(":hidden"))
		{
			$group.addClass("panel-closed");
			$switchText.slideDown();
			$switchInput.slideUp();
		}else{
			$group.removeClass("panel-closed");
			$switchText.slideUp();
			$switchInput.slideDown();
		}
		
	}
}



/*
函数名称：FormSearch.toggle(divID)
创建时间：20216-08-04
实现功能：关闭|打开 高级搜索
参　　数：search 的 div ID
*/
var FormSearch = {
	toggle : function(divID){
		var $divSearch = $("#" + divID);
		$hidFormGroup = $divSearch.find(".hid-form-group:eq(0)");
		if ($hidFormGroup.is(":hidden"))
		{
			$hidFormGroup.slideDown("fast");
		}else{
			$hidFormGroup.slideUp("fast");
		}
		
		WindowTimeoutResize();
	}
}


/*
函数名称：TreeFrame.toggle()
创建时间：20216-08-02
实现功能：关闭|打开 左侧栏
*/
var TreeFrame = {
	toggle:function(){
		var $rightSide = $(".div-rightside:eq(0)");
		if ($rightSide.hasClass("show-tree-panel"))
		{
			$rightSide.removeClass("show-tree-panel");
		}else{
			$rightSide.addClass("show-tree-panel");
		}
		WindowTimeoutResize();
	}
}


/*
函数名称：datagridResizeWidth()
创建时间：20216-08-04
实现功能：给 easyui grid 使用，窗口大小改变后，回调重新计算宽度
*/
function datagridResizeWidth(){
	var $rightSide = $(".div-rightside:eq(0)");
	var gridWidth = $rightSide.width() -  (parseInt($rightSide.css("padding-left")) * 2);
	return gridWidth;
}

/*
函数名称：NavTab()
创建时间：20216-08-04
实现功能：页签点击选中状态
*/
function NavTab(element){
	var $element = $(element);
	var $navtab = $element.parent().parent();
	$navtab.find("li").removeClass("active");
	$element.parent().addClass("active");
}


/*
函数名称：ModelWindow
创建时间：20216-08-04
实现功能：弹出框对象
*/
var ModelWindow = {
	_callback:null, //保存回调函数
	_close:function(divID,status){
		var _status = status?true:false;
		if (this._callback)
		{
			//回调函数返回 true, 窗口关闭，否则不关闭
			if (this._callback(_status))
			{
				//this._callback = null;
			}else{
				//this._callback = null;
//				return;
			}
		}
		$("body").removeClass("modal-open");
		$("#" +divID).removeClass("in");
		$(".modal-backdrop:last").removeClass("in");
		setTimeout(function(){
			$("#" +divID).remove();
			$(".modal-backdrop:last").remove();
		},150);
	},
	_open:function(divID){
		$("body").addClass("modal-open");
		$("#" +divID).css({"display":"block"});
		$("body").append("<div class='modal-backdrop fade in'></div>");
		var $modalDialog = $("#" +divID).find(".modal-dialog:eq(0)");
		var $winWidth = $(window).width();
		$modalDialog.css({left:(($winWidth - $modalDialog.width())/2),top:'50px'});
		var handleID = divID + "_handle";
		$modalDialog.find(".modal-header:eq(0)").attr("id",handleID);
		//使它能够拖放
		$modalDialog.draggable({ "handle":"#"+handleID });
		setTimeout(function(){
			$("#" +divID).addClass("in");
		});
	},
	_openWithoutMask:function(divID){
		$("#" +divID).css({"display":"block"});
		var $modalDialog = $("#" +divID).find(".modal-dialog:eq(0)");
		var $winWidth = $(window).width();
		$modalDialog.css({left:(($winWidth - $modalDialog.width())/2),top:'50px'});
		setTimeout(function(){
			$("#" +divID).addClass("in");
		});
	},
	msgbox:function(msg,title,width,callback){
		var _title = title?title:"系统消息";
		var _width = width?width:600;
		var html = "";
		var _id = "modelwindow_" + Math.round(Math.random() * 1000);
		html += "<div class=\"modal fade\" id=\"" + _id + "\" tabindex=\"-1\">";
		html += "		  <div class=\"modal-dialog\" style=\"width:" + _width + "px\">";
		html += "			<div class=\"modal-content\">";
		html += "			  <div class=\"modal-header\">";
		html += "				<button type=\"button\" class=\"close\"><span onclick=\"ModelWindow._close(\'" + _id + "\')\">&times;</span></button>";
		html += "				<h4 class=\"modal-title\">" + _title + "</h4>";
		html += "			  </div>";
		html += "			  <div class=\"modal-body\">";
		html += msg;
		html += "			  </div>";
		html += "			  <div class=\"modal-footer\">";
		html += "				  <button type=\"button\" class=\"btn btn-success\" onclick=\"ModelWindow._close(\'" + _id + "\')\"><span class=\"glyphicon glyphicon-ok\"></span> 确定</button>";
		html += "			  </div>";
		html += "			</div>";
		html += "		  </div>";
		html += "		</div>";
		html += "";
		$('body').append(html);
		this._open(_id);
		this._callback = null;
		if (callback)
		{	
			this._callback = callback;
		}
	},
	confirm:function(msg,title,width,callback){
		var _title = title?title:"系统消息";
		var _width = width?width:600;
		var html = "";
		var _id = "modelwindow_" + Math.round(Math.random() * 1000);
		html += "<div class=\"modal fade\" id=\"" + _id + "\" tabindex=\"-1\">";
		html += "		  <div class=\"modal-dialog\" style=\"width:" + _width + "px\">";
		html += "			<div class=\"modal-content\">";
		html += "			  <div class=\"modal-header\">";
		html += "				<button type=\"button\" class=\"close\"><span onclick=\"ModelWindow._close(\'" + _id + "\')\">&times;</span></button>";
		html += "				<h4 class=\"modal-title\">" + _title + "</h4>";
		html += "			  </div>";
		html += "			  <div class=\"modal-body\">";
		html += msg;
		html += "			  </div>";
		html += "			  <div class=\"modal-footer\">";
		html += "				  <button type=\"button\" class=\"btn btn-success\" onclick=\"ModelWindow._close(\'" + _id + "\',true)\"><span class=\"glyphicon glyphicon-ok\"></span> 是</button>";
		html += "				  <button type=\"button\" class=\"btn btn-default\" onclick=\"ModelWindow._close(\'" + _id + "\')\">否</button>";
		html += "			  </div>";
		html += "			</div>";
		html += "		  </div>";
		html += "		</div>";
		html += "";
		$('body').append(html);
		this._open(_id);
		this._callback = null;
		if (callback)
		{	
			this._callback = callback;
		}
	},
	open:function(url,title,width,callback){
		var _title = title?title:"系统消息";
		var _width = width?width:600;
		var html = "";
		var _id = "modelwindow_" + Math.round(Math.random() * 1000);
		html += "<div class=\"modal fade\" id=\"" + _id + "\" tabindex=\"-1\">";
		html += "		  <div class=\"modal-dialog\" style=\"width:" + _width + "px\">";
		html += "			<div class=\"modal-content\">";
		html += "			  <div class=\"modal-header\">";
		html += "				<button type=\"button\" class=\"close\"><span onclick=\"ModelWindow._close(\'" + _id + "\')\">&times;</span></button>";
		html += "				<h4 class=\"modal-title\">" + _title + "</h4>";
		html += "			  </div>";
		html += "			  <div class=\"modal-body\">";
		html += "				<div class=\"content-frame\"></div>";
		html += "			  </div>";
		html += "			  <div class=\"modal-footer\">";
		html += "				  <button type=\"button\" class=\"btn btn-success\" onclick=\"ModelWindow._close(\'" + _id + "\',true)\"><span class=\"glyphicon glyphicon-ok\"></span> 确定</button>";
		html += "				  <button type=\"button\" class=\"btn btn-default\" onclick=\"ModelWindow._close(\'" + _id + "\')\">取消</button>";
		html += "			  </div>";
		html += "			</div>";
		html += "		  </div>";
		html += "		</div>";
		html += "";
		$('body').append(html);
		$("#" + _id + " .content-frame:eq(0)").load(url + "?" + Math.random()); //加随机字符串防止缓存
		this._open(_id);
		this._callback = null;
		if (callback)
		{	
			this._callback = callback;
		}
	},
	tips:function(msg,sec){
		var _sec = sec?sec:1000;
		var html = "";
		var _id = "modelwindow_" + Math.round(Math.random() * 1000);
		html += "<div class=\"modal fade modal-tips\" id=\"" + _id + "\" tabindex=\"-1\">";
		html += "		  <div class=\"modal-dialog\" style=\"width:200px;\">";
		html += "			<div class=\"modal-content\">";
		html += "			  <div class=\"modal-body\" style=\"text-align:center;\">";
		html += msg;
		html += "			  </div>";
		html += "			</div>";
		html += "		  </div>";
		html += "		</div>";
		html += "";
		$('body').append(html);
		this._openWithoutMask(_id);
		var tmpWindow = this;
		setTimeout(function(){
			tmpWindow._close(_id);
		},_sec);
	}
}
/*
		html += "<div class=\"modal fade\" id=\"modalForm\" tabindex=\"-1\">";
		html += "		  <div class=\"modal-dialog\">";
		html += "			<div class=\"modal-content\">";
		html += "			  <div class=\"modal-header\">";
		html += "				<button type=\"button\" class=\"close\"><span onclick=\"ModalWindow.close(\'modalForm\')\">&times;</span></button>";
		html += "				<h4 class=\"modal-title\">" + _title + "</h4>";
		html += "			  </div>";
		html += "			  <div class=\"modal-body\">";
		html += msg;
		html += "			  </div>";
		html += "			  <div class=\"modal-footer\">";
		html += "				  <button type=\"button\" class=\"btn btn-success\" onclick=\"ModalWindow.close(\'modalForm\')\"><span class=\"glyphicon glyphicon-ok\"></span>确定</button>";
		html += "				  <button type=\"submit\" class=\"btn btn-default\" onclick=\"ModalWindow.close(\'modalForm\')\">取消</button>";
		html += "			  </div>";
		html += "			</div>";
		html += "		  </div>";
		html += "		</div>";
		html += "";
*/
