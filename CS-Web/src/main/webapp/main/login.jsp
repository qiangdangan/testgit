<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base_form.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	$(document).ready(function()
	{
		$("#userName").focus();
		easyloader.load('parser', function()
		{
			$('#userName').validatebox({
				required : true,
				validType : [
					"remote['${cxt}userLogin.ajaxUserNameIsExist.action','用户名']"
				],
				missingMessage : "请输入用户名",
				invalidMessage : "用户名不存在"
			});
			$('#password').validatebox({
				required : true,
				missingMessage : "请输入密码"
			});
			var url = "${cxt}userLogin.login.action";
			$("#frm_login").form({
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
					var obj = eval("(" + data + ")");
					var flag = obj.retFlag;
					if (flag == "10")
					{
						//用户名或密码错误
						ModelWindow.msgbox('用户名或密码错误，请确认。', '温馨提示', null, null);
					}
					else if (flag == "20")
					{
						//不允许登录
						ModelWindow.msgbox('不允许您的账户登录，请联系管理员。', '温馨提示', null, null);
					}
					else if (flag == "30")
					{
						//没权限
						ModelWindow.msgbox('您没有权限登录系统，请联系管理员。', '温馨提示', null, null);
					}
					else if (flag == "90")
					{
						//系统错误
						ModelWindow.msgbox('很抱歉系统发生错误，请重试或联系管理员。', '温馨提示', null, null);
					}
					else if (flag == "100")
					{
						//可以登录
						loadPageByForm("${cxt}userLogin.initLoginUserInfo.action");
					}

				}
			});
		})
	});
</script>
</head>
<body class="body-theme-1">
	<div class="div-login">
		<div class="section-title">后台登录</div>
		<form id="frm_login" method="post">
			<div class="form-group">
				<label>用户名</label> <input type="text" name="userName" id="userName"
					class="form-control" placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<label>密码</label> <input type="password" name="password"
					id="password" class="form-control" placeholder="请输入密码">
			</div>
			<button type="submit" class="btn btn-info btn-block">登录</button>
			<button type="button" class="btn btn-default btn-block">忘记密码？</button>
		</form>

		<div class="clear"></div>
	</div>
	<!-- div-welcome -->
</body>
</html>
