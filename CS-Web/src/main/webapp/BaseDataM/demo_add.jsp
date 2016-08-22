<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base_form.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">

	//返回
	function btn_FanHui_OnClick()
	{
		loadPageByForm("${cxt}test.listUI.action");
	}
	//提交form
	function submitForm()
	{
		
		if ($("#frm_demo").form("validate"))
		{
			ModelWindow.confirm('是否确保存数据？', '系统确认', null, function(status)
			{
				if (status)
				{
					$("#frm_demo").submit()
				}
			});
		}
	}

	function initAddPage()
	{
		
		//姓名
		$('#tbx_username').validatebox({
			required : true,
			validType : [
					"maxLength[100]", "remote['${cxt}test.ajaxValidateNameIsExist.action','姓名']"
			]
		});
		//年龄
		$('#tbx_age').validatebox({
			required : true,
			validType : [
				"integer"
			]
		});
		$.extend($.fn.validatebox.defaults.rules, {   
		    selectValueRequired: {   
		        validator: function(value,param){             
		             if (value == "" || value.indexOf('请选择') >= 0) {   
		                return false;  
		             }else {  
		                return true;  
		             }    
		        },   
		        message: '该下拉框为必选项'   
		    }   
		}); 
		$('#cmb_sex').combobox({
			editable : false,
			prompt : '请选择性别',
			required : true,
			validType : 'selectValueRequired',
			missingMessage : "请选择性别。",
			onLoadSuccess : function()
			{
			}
		});
		//联系电话
		$('#tbx_phone').validatebox({
			required : true,
			validType : [
					"mobileAndPhone", "maxLength[20]"
			]
		});
		//email
		$('#tbx_email').validatebox({
			required : true,
			validType : [
					"email", "maxLength[100]"
			]
		});
		//专业
		$('#tbx_zhuanye').validatebox({
			required : true,
			validType : [
				"maxLength[50]"
			]
		});
		//简介
		$('#tbx_jianjie').validatebox({
			required : false,
			validType : [
				"maxLength[20]"
			]
		});
	}
	$(document).ready(function()
	{
		initAddPage();

		easyloader.load('parser', function()
		{
			var url = "${cxt}test.saveDemo.action";
			$("#frm_demo").form({
				url : url,
				onSubmit : function()
				{
					var ret = $(this).form("validate");
					if (ret)
					{
						showSubmitLoading("提示信息", "正在提交数据，请稍后", 10, 500, 100);//显示 提交 提示
					}
					return ret;
				},
				success : function(data)
				{
					hideSubmitLoading();
					var obj = eval(data);
					if (obj)
					{
						ModelWindow.msgbox('保存成功！', '温馨提示', null, function()
						{
							btn_FanHui_OnClick();
						});
					}
					else
					{
						ModelWindow.msgbox('保存失败，请尝试刷新页面或联系系统管理员！', '温馨提示', null, null);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 顶部导航栏 -->
	<jsp:include page="/main/header.jsp"></jsp:include>
	<!-- 左部菜单 -->
	<jsp:include page="/main/left.jsp"></jsp:include>
	<div class="div-rightside">

		<ol class="breadcrumb">
			${mianBaoXieHtml}
			<li class="active">添加DEMO</li>
		</ol>

		<div class="main-frame">
			<form id="frm_demo" action="" method="post">
				<!-- 组开始 -->
				<div class="section-title">一列表单</div>
				<div class="form-horizontal">
					<div class="form-group col-sm-12">
						<label class="fg-text control-label">姓名</label>
						<div class="fg-input">
							<input type="text" class="form-control"
								id="tbx_username" name ="demo.username" placeholder="请输入姓名">
						</div>
					</div>
				</div>
				<!-- 组结束 -->
	
	
				<!-- 组开始 -->
				<div class="section-title">二列表单</div>
				<div class="form-horizontal">
					<div class="form-group col-sm-6">
						<label class="fg-text control-label">年龄</label>
						<div class="fg-input">
							<input type="text" class="form-control"
								id="tbx_age" name ="demo.age" placeholder="请输入年龄">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="fg-text control-label">性别</label>
						<div class="fg-input">
							<select id="cmb_sex" name="demo.sex" style="width:100%">
								<option value=""></option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</div>
					</div>
				</div>
				<!-- 组结束 -->
	
	
				<!-- 组开始 -->
				<div class="section-title">三列表单</div>
				<div class="form-horizontal">
					<div class="form-group col-sm-6 col-md-4">
						<label class="fg-text control-label">联系电话</label>
						<div class="fg-input">
							<input type="text" class="form-control"
								id="tbx_phone" name ="demo.phone" placeholder="请输入联系电话">
						</div>
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label class="fg-text control-label">E-mail</label>
						<div class="fg-input">
							<input type="text" class="form-control"
								id="tbx_email" name ="demo.email" placeholder="请输入email">
						</div>
					</div>
					<div class="form-group col-sm-6 col-md-4">
						<label class="fg-text control-label">专业</label>
						<div class="fg-input">
							<input type="text" class="form-control"
								id="tbx_zhuanye" name ="demo.zhuanye" placeholder="请输入专业">
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="fg-text control-label">个人简介</label>
						<div class="fg-input">
							<textarea id="tbx_jianjie" name ="demo.jianjie" rows="" cols="" class="form-control" placeholder="请输入个人简介"></textarea>
						</div>
					</div>
					<div class="form-btns">
						<button type="button" onclick="submitForm()" class="btn btn-success">
							<span class="glyphicon glyphicon-ok"></span> 确定保存
						</button>
						<button type="button" onclick="btn_FanHui_OnClick();" class="btn btn-default">取消</button>
					</div>
				</div>
				<!-- 组结束 -->

			</form>
		</div>
		<!-- main-frame -->

	</div>
	<!-- div-rightside -->
</body>
</html>
