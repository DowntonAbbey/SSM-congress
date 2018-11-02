<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/Style/skin.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/Js/jquery.min.js"></script>
<script type="text/javascript">
	function goPage(pageIndex){
		$("#form1").attr("action","${pageContext.request.contextPath}/resource/list.action?pageIndex="+pageIndex);
		$("#form1").submit();
	}
	function add() {
		window.location.href = "${pageContext.request.contextPath}/page/resource/add.action";
	}
	
	function deleteByNewsIds() {        
		var chk_value = [];//定义一个数组        
		//利用将name等于ids的多选按钮得到       
		$("input[name='ids']:checked").each(function() {        
			//将选中额数据存到数组里       
			chk_value.push($(this).val());        
			});
		if (chk_value.length == 0) {            
			alert("你还没有选择任何内容！");        
			}       
		if (chk_value.length > 0) {           
			location.href ="${pageContext.request.contextPath}/resource/deleteByIds.action?idString=" + chk_value;        
			}
	}
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<!-- 头部开始 -->
		<tr>
			<td width="17" valign="top" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">
				<img src="${pageContext.request.contextPath}/static/Images/left_top_right.gif" width="17" height="29" />
			</td>
			<td valign="top" background="${pageContext.request.contextPath}/static/${pageContext.request.contextPath}/static/Images/content_bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" background="${pageContext.request.contextPath}/static/Images/content_bg.gif">
					<tr>
						<td height="31"><div class="title">会议资料管理</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top" background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif"><img
				src="${pageContext.request.contextPath}/static/Images/nav_right_bg.gif" width="16" height="29" /></td>
		</tr>
		<!-- 中间部分开始 -->
		<tr>
			<!--第一行左边框-->
			<td valign="middle" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">&nbsp;</td>
			<!--第一行中间内容-->
			<td valign="top" bgcolor="#F7F8F9">
				<table style="width: 100%" width="100%" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<!-- 空白行-->
					<tr>
						<td colspan="2" valign="top">&nbsp;</td>
						<td>&nbsp;</td>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">
							<form class="clearfix" action="${pageContext.request.contextPath}/emp/list/1" id="form1" method="post">
								<div style="float: left">
									<p style="float: left; margin-left: 30px;">
										<label>会议标题：</label>
										<input class="text" list="rolelist" name="name" value="${p.bean}" style="width: 80px;" />
									</p>
									&nbsp;&nbsp;&nbsp;

									<p style="float: left; margin-left: 30px;">
										<input type="submit" class="btn" value="查询" />
									</p>
								</div>
								<div style="float: right">
									<input type="button" onclick='add()'
										class="btn" value="添加" /> &nbsp;&nbsp;&nbsp; <input
										type="button" class="btn" onclick='deleteByNewsIds()' value="批量删除" />
								</div>
							</form> <datalist id="rolelist">
							<option></option>
							<option></option>
							</datalist>
							<td>
					</tr>
					<!-- 一条线 -->
					<tr>
						<td height="40" colspan="4">
							<table width="100%" height="1" border="0" cellpadding="0"
								cellspacing="0" bgcolor="#CCCCCC">
								<tr>
									<td></td>
								</tr>
							</table>
						</td>
					</tr>
					<!-- 列表展示开始 -->
					<tr>
						<td width="2%">&nbsp;</td>
						<td width="96%">
							<table width="100%">
								<tr>
									<td colspan="2">
										<form action="" method="">
											<table width="100%" class="cont tr_color">
												<tr>
													<th><input type="checkbox" value="" /></th>
													<th>会议资料标题</th>
													<th>会议资料地址</th>
													<th>会议资料细节</th>
													<th>操作</th>
												</tr>
											<c:forEach items="${resources}" var="e">
												<tr align="center" class="d">
													<td><input type="checkbox" value="${e.resourceId }" name="ids" /></td>
													<td>${e.noticeName}</td>
													<td>${e.noticeAddress}</td>
													<td>${e.resourceDetail}</td>
													<td><a href="${pageContext.request.contextPath}/resource/updateById.action?resourceId=${e.resourceId}">修改</a>&nbsp;&nbsp; <a
														href="${pageContext.request.contextPath}/resource/deleteById.action?resourceId=${e.resourceId}" onclick="del()">删除</a>
													</td>
												</tr>
                                                </c:forEach>
											</table>
										</form>
									</td>
								</tr>
							</table>
						</td>
						<td width="2%">&nbsp;</td>
					</tr>
				 <!--列表展示结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="51%" class="left_txt">
                           		<input type="button" value="全选" />&nbsp;&nbsp;&nbsp;
                                <input type="button" value="反选" />
                            <div style="float:right;"><b>
                                <a href="#" onclick="goPage(1);">首页</a>&nbsp;&nbsp;&nbsp;
                                <c:if test="${p.pageIndex-1 > 0}">
									<a href="#" onclick="goPage(${p.pageIndex-1});">上一页</a>&nbsp;&nbsp;&nbsp;
								</c:if>
								<c:forEach begin="${p.startNum}" end="${p.endNum}" step="1" var="num">
									      <c:if test="${num==p.pageIndex}">
									          <span style="color: red;">${num}</span>&nbsp;&nbsp;&nbsp;
									      </c:if>
									      <c:if test="${num!=p.pageIndex}">
									         <a href="#" onclick="goPage(${num});">${num}</a>&nbsp;&nbsp;&nbsp;
									      </c:if>
									</c:forEach>
								<c:if test="${p.pageIndex-1 < pageCount}">
									<a href="#" onclick="goPage(${p.pageIndex+1});">下一页</a>&nbsp;&nbsp;&nbsp;
								</c:if>
								<a href="#" onclick="goPage(${p.pageCount});">末页</a>&nbsp;&nbsp;&nbsp;
								每页显示${p.pageSize}条&nbsp;&nbsp;&nbsp;
								当前 ${p.pageIndex}/${p.pageCount}页&nbsp;&nbsp;&nbsp;
								共${p.totalCount}条
                            </b></div>
                            
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
			</td>
			<td background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif">&nbsp;</td>
		</tr>
		<!-- 底部部分 -->
		<tr>
			<td valign="bottom" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif"><img
				src="${pageContext.request.contextPath}/static/Images/buttom_left.gif" width="17" height="17" /></td>
			<td background="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif"><img
				src="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif"><img
				src="${pageContext.request.contextPath}/static/Images/buttom_right.gif" width="16" height="17" /></td>
		</tr>
	</table>
</body>
</html>