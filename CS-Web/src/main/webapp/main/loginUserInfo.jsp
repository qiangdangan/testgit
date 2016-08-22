<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base_form.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//角色单击事件
	function jueSe_Onclick(jsid,jsmc)
	{
		loadPageByForm("${cxt}userLogin.initMain.action?jsid="+jsid+"&jsmc="+jsmc);
	}
</script>
</head>

<body>

	<!-- 顶部工具条 -->
	<jsp:include page="/main/houTaiTopBar.jsp"></jsp:include>
	<ol class="breadcrumb">
	  <li><a href="#"></a></li>
	  <li><a href="#"></a></li>
	  <li><a href="#"></a></li>
	</ol>
	<div class="div-welcome">

		<div class="section-title">登录信息</div>
		<ul class="list-group">
			<li class="list-group-item">欢迎您：${loginUserInfo.xingMing}</li>
			<li class="list-group-item">职工号：${loginUserInfo.zhiGongHao}</li>
			<li class="list-group-item">单 位：${loginUserInfo.jiGouQuanCheng}-${loginUserInfo.buMenMingCheng}</li>
			<li class="list-group-item">登录IP：${loginUserIp}</li>
			<li class="list-group-item">上次登录：${shangCiDengLuShiJian}</li>
		</ul>
		<div class="section-title">用户角色</div>
		
		<c:forEach items="${loginUserInfo.jueSeList}" var="jueSe">
		<div class="col-sm-4">
			<div class="input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-user"></span></span>
				<button type="button" onclick="jueSe_Onclick('${jueSe.XTJS_ID}','${jueSe.JueSeMingCheng}')"
					class="btn btn-default btn-block">${jueSe.JueSeMingCheng}</button>
			</div>
		</div>
		</c:forEach>
		
		<div class="clear"></div>

	</div>
	<!-- div-welcome -->

</body>
</html>
