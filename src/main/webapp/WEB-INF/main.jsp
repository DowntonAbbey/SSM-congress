<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>

<!--导入样式文件-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/Style/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/Style/themes/default/easyui.css" />
<!--导入js的文件-->
<script src="${pageContext.request.contextPath}/static/Js/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/Js/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>

</head>

<body>
<body class="easyui-layout">
	<div data-options="region:'center'">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west'" style="width: 180px">
				<!--编写我们的菜单-->
				<a id="btn" href="#" onclick="addTable('用户管理','/user/list.action')"
					class="easyui-linkbutton" data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">用&nbsp;&nbsp;户&nbsp;&nbsp;管&nbsp;&nbsp;理</a><br />
				<a id="btn" href="#" class="easyui-linkbutton" onclick="addTable('职位管理','staff/list.action')"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">职&nbsp;&nbsp;位&nbsp;&nbsp;管&nbsp;&nbsp;理</a><br /> 
				<a id="btn" href="#" class="easyui-linkbutton" onclick="addTable('代表团管理','delegation/list.action')"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">代&nbsp;表&nbsp;团&nbsp;管&nbsp;理</a><br /> 
				<a id="btn" href="#" class="easyui-linkbutton" onclick="addTable('员工管理','emp/list.action')"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">员&nbsp;&nbsp;工&nbsp;&nbsp;管&nbsp;&nbsp;理</a><br />
				<a id="btn" href="#" class="easyui-linkbutton" onclick="addTable('部门管理','dept/list.action')"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">部&nbsp;&nbsp;门&nbsp;&nbsp;管&nbsp;&nbsp;理</a><br />
				<a id="btn" href="#" onclick="addTable('会议新闻管理','news/list.action')" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">会议新闻管理</a><br /> 
				<a id="btn" href="#" class="easyui-linkbutton" onclick="addTable('会议通知管理','/notice/list.action')"
					data-options="iconCls:'icon-edit'"
					style="margin-top: 10px; width: 170px;">会议通知管理</a><br /> 
				<a id="btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'" onclick="addTable('会议议程管理','agenda/list.action')"
					style="margin-top: 10px; width: 170px;">会议议程管理</a><br /> 
				<a id="btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'" onclick="addTable('座次安排管理','seat/list.action')"
					style="margin-top: 10px; width: 170px;">座次安排管理</a><br />
			</div>
			<div data-options="region:'center'">
				<!--申明我们的tabs容器-->
				<div id="tt" class="easyui-tabs"
					data-options="fit:true,border:false"></div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	/* 	$(document).ready(function() {
			$('a').click(function() {
				//第一步:判断当前点击的是谁?
				//var val=this.innerText;	
				var val = $(this).text();
				//第二步:判断当前是否已经添加过这个tab到容器里了
				//去掉空格之后再进行比较
				val = val.trim();

				var b = $("#tt").tabs("exists", val);

				if(!b) {
					addTable(val);
				}else{
					//打开这个tab
					 $("#tt").tabs("select", val);
				}
			})
		}) */
	function addTable(tabName, url) {
		var pathName = window.location.pathname.substring(1);
		var webName = pathName == '' ? '' : pathName.substring(0, pathName
				.indexOf('/'));
		var url = window.location.protocol + '//' + window.location.host + '/'
				+ webName + '/' + url;
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';

		var b = $("#tt").tabs("exists", tabName);
		console.log("url:"+url);
		if (!b) {
			$('#tt').tabs('add', {
				title : tabName,
				content : content,
				closable : true,
			});
		} else {
			$("#tt").tabs("select", tabName);
		}

	}
</script>

</body>

</html>