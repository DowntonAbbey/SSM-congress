<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/Style/skin.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/Js/jquery.min.js"></script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<!-- 头部开始 -->
		<tr>
			<td width="17" valign="top"
				background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">
				<img
				src="${pageContext.request.contextPath}/static/Images/left_top_right.gif"
				width="17" height="29" />
			</td>
			<td valign="top"
				background="${pageContext.request.contextPath}/static/Images/content_bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0"
					background="${pageContext.request.contextPath}/static/Images/content_bg.gif">
					<tr>
						<td height="31"><div class="title">用户添加</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top"
				background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif"><img
				src="${pageContext.request.contextPath}/static/Images/nav_right_bg.gif"
				width="16" height="29" /></td>
		</tr>
		<!-- 中间部分开始 -->
		<tr>
			<!--第一行左边框-->
			<td valign="middle"
				background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">&nbsp;</td>
			<!--第一行中间内容-->
			<td valign="top" bgcolor="#F7F8F9">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<!-- 空白行-->
					<tr>
						<td colspan="2" valign="top">&nbsp;</td>
						<td>&nbsp;</td>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"></td>
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
					<!-- 角色修改开始 -->
					<tr>
						<td width="2%">&nbsp;</td>
						<td width="96%">
							<table width="100%">
								<tr>
									<td colspan="2">
										<form action="${pageContext.request.contextPath}/user/add.action" method="post" enctype="multipart/form-data">
											<table width="100%" class="cont">
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="8%"><font color="red"><b>*</b></font>登录名：</td>
													<td width="25%"><input class="text" placeholder="必填"
														name="userLoginName" /></td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="8%"><font color="red"><b>*</b></font>电话号码：</td>
													<td width="25%"><input class="text" placeholder="必填"
														name="telNum" /></td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="8%"><font color="red"><b>*</b></font>选择照片：</td>
													<td width="25%"><input type="file" name="file"></td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="8%"><font color="red"><b>*</b></font>姓名：</td>
													<td width="25%"><input type="text" class="text"
														placeholder="必填" name="userRealName" /></td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td><font color="red"><b>*</b></font>职位</td>
													<td>
														<select name="staffParam" id="staffSelect">
															<option value="">--请选择职位--</option>
														</select>
													</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>

												<tr>
													<td width="2%">&nbsp;</td>
													<td><font color="red"><b>*</b></font>代表团</td>
													<td>
														<select class="easyui-select" name="delegation.delegationId" id="delegationSelect">
															<option value="">--请选择代表团--</option>
														</select>
													</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>

												<tr>
													<td>&nbsp;</td>
													<td colspan="2" align="center"><input class="btn"
														type="submit" value="提交" />&nbsp;&nbsp;&nbsp; <input
														class="btn"
														onclick="location.href='${pageContext.request.contextPath}/user/list'"
														type="button" value="返回" /></td>
													<td></td>
													<td>&nbsp;</td>
												</tr>
											</table>
										</form>
									</td>
								</tr>
							</table>
						</td>
						<td width="2%">&nbsp;</td>
					</tr>
					<!-- 角色添加结束 -->
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
					<tr>
						<td width="2%">&nbsp;</td>
						<td width="51%" class="left_txt"></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>


			<td
				background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif">&nbsp;</td>
		</tr>
		<!-- 底部部分 -->
		<tr>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">
				<img
				src="${pageContext.request.contextPath}/static/Images/buttom_left.gif"
				width="17" height="17" />
			</td>
			<td
				background="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif">
				<img
				src="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif"
				width="17" height="17">
			</td>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif">
				<img
				src="${pageContext.request.contextPath}/static/Images/buttom_right.gif"
				width="16" height="17" />
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/staff/staffType.action",
				dataType:"json",
				success:function(result){
					for(var i=0;i<result.length;i++){
						  var staffId=result[i].staffId;
						  var staffName=result[i].staffName;
						  $("#staffSelect").append("<option value='"+staffId+"'>"+staffName+"</option>");
					  }
				}
			});
			
			$.ajax({
				url:"${pageContext.request.contextPath}/delegation/delegationType.action",
				dataType:"json",
				success:function(result){
					for(var i=0;i<result.length;i++){
						  var delegationId=result[i].delegationId;
						  var delegationName=result[i].delegationName;
						  $("#delegationSelect").append("<option value='"+delegationId+"'>"+delegationName+"</option>");
					  }
				}
			});
		})
	</script>
</body>
</html>