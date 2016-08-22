<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String ipAndPortPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	String basePath = ipAndPortPath + path + "/";
	request.setAttribute("basePath", basePath);
	String xiangMuPath = request.getSession().getServletContext().getRealPath("/");
	xiangMuPath = xiangMuPath.replaceAll("\\\\", "/");
	request.setAttribute("xiangMuPath", xiangMuPath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="cxt" value="${basePath}"></c:set>
<c:set var="xiangMuPath" value="${xiangMuPath}"></c:set>
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<title>客户服务管理信息平台</title>
<style type="text/css">
textarea {
	resize: none;
}
</style>
<script type="text/javascript">
	var _moKuaiId='${moKuaiId}';
	var _jieDianId='${jieDianId}';
</script>
