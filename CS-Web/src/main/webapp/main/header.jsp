<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//编辑用户信息
	function moKuai_OnClick(mkid)
	{
		_moKuaiId=mkid
		_jieDianId='';
		loadPageByForm("${cxt}userLogin.caiDanTiaoZhuan.action");
	}
</script>
</head>

<body>
	<!-- 顶部工具条 -->
	<jsp:include page="/main/houTaiTopBar.jsp"></jsp:include>
	<div class="div-catalog">
		<div class="header-menu">
			<ul>
				<c:forEach items="${userMoKuai}" var="mk">
				<li>
					<a ${mk.CDID eq moKuaiId ? "class='active'" : ""} href="javascript:void(0);" onclick="moKuai_OnClick('${mk.CDID}')">
						<span class="glyphicon ${mk.CaiDanTuBiao}"></span>${mk.CaiDanMingCheng}
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		<!-- header-menui -->
		<div class="dc-title">
			<div class="dc-name"><span class="glyphicon glyphicon-time"></span>
			<c:forEach items="${userMoKuai}" var="mk">
				${mk.CDID eq moKuaiId ? mk.CaiDanMingCheng : ""}
			</c:forEach>
			</div>
		</div>
	</div>
	<!-- catalog -->
</body>
</html>
