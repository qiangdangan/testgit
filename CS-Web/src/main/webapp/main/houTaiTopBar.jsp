<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//角色单击事件
	
	function qieHuanJueSe_Onclick(jsid, jsmc)
	{
		if (jsid == '${loginUserInfo.nowJueSeId}')
		{
			ModelWindow.msgbox('您当前的角色已经是【' + jsmc + '】了，请确认。', '温馨提示', null, null);
		}
		else
		{
			loadPageByForm("${cxt}userLogin.initMain.action?jsid=" + jsid + "&jsmc=" + jsmc);
		}
	}
	//编辑用户信息
	function edit_userInfo()
	{

	}
	//退出登录
	function loginOut()
	{
		ModelWindow.confirm('您是否要退出系统？', '系统确认', null, function(status)
		{
			if (status)
			{
				loadPageByForm("${cxt}userLogin.loginOut.action");
			}
			else
			{

			}
		});
	}
</script>
</head>

<body class="body-theme-1">

	<div class="div-header">
		<div class="container-fluid">
			<div class="header-title">客户服务管理信息平台</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${cxt}userLogin.initLoginUserInfo.action">首页</a></li>
				<!-- 				<li><a href="shouYe.html">后台首页</a></li> -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">切换角色
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<c:forEach items="${loginUserInfo.jueSeList}" var="jueSe">
						<li><a href="javascript:void(0);" onclick="qieHuanJueSe_Onclick('${jueSe.XTJS_ID}','${jueSe.JueSeMingCheng}')"><span class="glyphicon glyphicon-user"></span>${jueSe.JueSeMingCheng}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"><span
						class="glyphicon glyphicon-user"></span>
						欢迎您：${loginUserInfo.xingMing}</a>
					<div class="dropdown-menu dropdown-user">
						<div class="pop-dropdown-apps user-tk">
							<div class="pda_arr"></div>
							<dl class="pda-list user_pda">
								<img src="${cxt}resources/images/moRenTouXiang.jpg">
								<div class="userright-list">
									<h1>${loginUserInfo.xingMing}&nbsp;&nbsp;|&nbsp;&nbsp;${loginUserInfo.zhiGongHao}</h1>
									<h2>
										<b>单位/部门：</b>${loginUserInfo.jiGouJianCheng}-${loginUserInfo.buMenMingCheng} <br> <b>角&nbsp; &nbsp;色：${loginUserInfo.nowJueSeMingCheng}</b>
									</h2>
								</div>
								<div class="clear"></div>
								<div class="select-themes">
									<ul>
										<li><a data-theme="body-theme-1"
											class="theme_1_thumb active" href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-2" class="theme_2_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-3" class="theme_3_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-4" class="theme_4_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-5" class="theme_5_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-6" class="theme_6_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
										<li><a data-theme="body-theme-7" class="theme_7_thumb"
											href="javascript:;"><span
												class="glyphicon glyphicon-ok-sign"></span></a></li>
									</ul>
								</div>
								<div class="userexit">
									<button id="btn_FanHui2" type="button"
										onclick="edit_userInfo()" class="btn btn-info addbtm"
										style=" padding-top:4px;">
										<span class="glyphicon glyphicon-pencil"></span> 编辑信息
									</button>
									<button onclick="loginOut()" type="button"
										class="btn btn-default">退出登录</button>
								</div>
								<div class="clear"></div>
							</dl>

						</div>
					</div></li>
			</ul>
		</div>
		<!-- container-fluid -->

	</div>
</body>
</html>
