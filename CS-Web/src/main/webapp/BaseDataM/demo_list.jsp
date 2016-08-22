<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/base_list.jsp"%>
<html>
<head>
<script type="text/javascript">
	//获取列表查询参数的对象
	function getQueryParams()
	{
		var queryParams = {
			userName : $("#tbx_userName").val(),
			age : $("#tbx_age").val(),
			sex : $("#cmb_sex").find("option:selected").val(),
			phone : $("#tbx_phone").val()
		};
		return queryParams;
	}
	//查询
	function btn_Search_OnClick()
	{
		search_btn_OnClick("tab_testDemo", getQueryParams);
	}
	//操作列渲染
	function editRowFormater(value, row, index)
	{
		var html="";
		html+="<div class='td-lnks'>";
		html+="	<a title='编辑' class='toggle-tooltip' onclick='btn_Edit_OnClick(\"" + value + "\");' href='javascript:void(0)'><span class='glyphicon glyphicon-pencil'></span></a>";
		html+="	<a title='删除' class='toggle-tooltip' onclick='btn_Delete_OnClick(\"" + value + "\");' href='javascript:void(0)'><span class='glyphicon glyphicon-trash'></span></a>";
		html+="</div>";
		return html;
	}
	//添加
	function btn_Add_OnClick()
	{
		loadPageByForm("${cxt}test.initAddPage.action");
	}
	//修改
	function btn_Edit_OnClick(id)
	{
		loadPageByForm("${cxt}test.initEditPage.action?id="+id);
	}
	//单个删除
	function btn_Delete_OnClick(id)
	{
		ModelWindow.confirm('是否确认删除所选人员？', '系统确认', null, function(status)
		{
			if (status)
			{
				delelteDemo(id);
			}
		});
	}
	//批量删除
	function btn_PiLiangDelete_OnClick()
	{
		var ids="";
		var rows = $('#tab_testDemo').datagrid('getSelections');
		if (rows.length == 0)
		{
			ModelWindow.msgbox('请选择需要删除的人员！', '温馨提示', null, null);
			return;
		}
		$.each(rows, function(index, row)
		{
			if (index == 0)
			{
				ids += row.id;
			}
			else
			{
				ids += "," + row.id;
			}
		});
		ModelWindow.confirm('是否确认删除所选人员？', '系统确认', null, function(status)
		{
			if (status)
			{
				delelteDemo(ids);
			}
		});
	}
	//删除demo
	function delelteDemo(ids)
	{
		console.log(ids);
		var url = '${cxt}test.deleteDemo.action?rd=' + Math.round(Math.random() * 10000);
		var data = 'ids=' + ids;
		initAjax(url, data, false, 'json', function(objflag)
		{
			hideAjaxLoading();
			if (objflag)
			{
				ModelWindow.msgbox('删除成功！', '温馨提示', null, btn_Search_OnClick);
			}
			else
			{
				ModelWindow.msgbox('删除失败，请尝试刷新页面或联系系统管理员！', '温馨提示', null, null);
			}
		});		
	}
	var footPager = new Pager("footPager");
	function initPage()
	{
		//初始化列表
		var url = "${cxt}test.searchTest.action";
		getGridJsonList("tab_testDemo", url, false, footPager, getQueryParams);
	}
	$(document).ready(function()
	{
		initPage();
	});
</script>
</head>
<body>
	<!-- 顶部导航栏 -->
	<jsp:include page="/main/header.jsp"></jsp:include>
	<!-- 左部菜单 -->
	<jsp:include page="/main/left.jsp"></jsp:include>

	<div class="div-rightside">
		<ol class="breadcrumb">${mianBaoXieHtml}</ol>
		<div class="main-frame">
			<ul class="nav nav-tabs">
				<li class="active"><a onclick="NavTab(this)" href="#">全部</a></li>
				<li><a onclick="NavTab(this)" href="#">待提交</a></li>
				<li><a onclick="NavTab(this)" href="#">待审核</a></li>
			</ul>
			<div class="form-search" id="divFormSearch">
				<div class="form-horizontal search-normal">
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label class="fg-text control-label">姓名</label>
						<div class="fg-input">
							<input type="text" id="tbx_userName" name="userName"
								onkeypress="tbx_OnKeyPressCallBack(this,btn_Search_OnClick);"
								class="form-control" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label class="fg-text control-label">年龄</label>
						<div class="fg-input">
							<input type="text" id="tbx_age" name="age"
								onkeypress="tbx_OnKeyPressCallBack(this,btn_Search_OnClick);"
								class="form-control" placeholder="请输入年龄">
						</div>
					</div>
					<div class="hid-form-group">
						<div class="form-group col-sm-6 col-md-4 col-lg-3">
							<label class="fg-text control-label">手机</label>
							<div class="fg-input">
								<input type="text" id="tbx_phone" name="phone"
									onkeypress="tbx_OnKeyPressCallBack(this,btn_Search_OnClick);"
									class="form-control" placeholder="请填写这一个字段">
							</div>
						</div>
						<div class="form-group col-sm-6 col-md-4 col-lg-3">
							<label class="fg-text control-label">性别</label>
							<div class="fg-input">
								<select id="cmb_sex" name="sex" class="select-dropkick"
									onchange="cmb_ChangeCallBack(this,btn_Search_OnClick);"
									style="width:100%">
									<option value="">全部</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label class="fg-text control-label">&nbsp;</label>
						<div class="fg-input">
							<div class="btn-group">
								<button type="button" class="btn btn-info"
									onclick="btn_Search_OnClick()">
									<span class="glyphicon glyphicon-search"></span> 搜索
								</button>
								<button type="button" class="btn btn-default"
									onclick="FormSearch.toggle('divFormSearch')">高级</button>
							</div>
						</div>
					</div>

				</div>

			</div>
			<!-- form-search -->
			<div class="table-toolbar">
				<div class="btn-toolbar">
					<ul>
						<li><button type="button" class="btn btn-default" onclick="btn_Add_OnClick()"><span class="glyphicon glyphicon-plus"></span>添加</button></li>
						<li><button type="button" class="btn btn-default" onclick="btn_PiLiangDelete_OnClick()"><span class="glyphicon glyphicon-trash"></span>删除</button></li>
					</ul>
				</div>
			</div>
			<div class="table-normal">
				<table id="tab_testDemo" cellpadding="0" cellspacing="0" border="0">
					<thead>
						<tr>
							<th data-options="field:'ck',checkbox:true"></th>
							<th data-options="field:'id',width:60,formatter:editRowFormater">操作</th>
							<th data-options="field:'username',width:120">姓名</th>
							<th data-options="field:'age',width:80">年龄</th>
							<th data-options="field:'sex',width:80">性别</th>
							<th data-options="field:'phone',width:500">手机</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<!-- main-frame -->
	</div>
	<!-- div-rightside -->
</body>
</html>
