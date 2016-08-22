<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//编辑用户信息
	function jieDian_OnClick(jdid, url)
	{
		if(url==null || url=='')
		{
			url="userLogin.initDefaultJdPage.action";
		}
		_moKuaiId='${moKuaiId}';
		_jieDianId=jdid;
		loadPageByForm("${cxt}" + url);
	}
</script>
</head>

<body>
	<div class="div-leftside-bg"></div>
	<div class="div-leftside">

		<div class="leftside-switch" onclick="LeftNav.toggle()">
			<span class="caret"></span>
		</div>
		<div class="left-nav">
			<c:forEach items="${userCaiDanZu}" var="cdz">
				<c:if test="${cdz.PID eq moKuaiId}">
					<div class="left-nav-group">
						<div class="lng-toggle">
							<span class="caret"></span>
						</div>
						<h2>${cdz.CaiDanMingCheng}</h2>
						<ul>
							<c:forEach items="${userCaiDan}" var="cd">
								<c:if test="${cd.PID eq cdz.CDID}">
									<li><a ${cd.CDID eq jieDianId ? "class='active'" : ""}
										href="javascript:void(0);"
										onclick="jieDian_OnClick('${cd.CDID}','${cd.URL }')">${cd.CaiDanMingCheng}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</c:if>
			</c:forEach>

			<!-- left-nav-group -->

		</div>
		<!-- left-nav -->


	</div>
	<!-- div_leftside -->
</body>
</html>
