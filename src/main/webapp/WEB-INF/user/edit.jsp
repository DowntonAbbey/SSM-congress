<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/Style/skin.css" />
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">
                    <img src="Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="${pageContext.request.contextPath}/static/Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/static/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">修改</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif"><img src="${pageContext.request.contextPath}/static/Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4">
                               
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 展示详情开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="${pageContext.request.contextPath}/user/update" method="post">
                                                <table width="100%"class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="8%">姓名：</td>
                                                        <td width="25%"><input class="text" value="${user.userName }" name="userName"/></td>
                                                        <input type="hidden" value="${user.userId }" name="userId"/>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="8%"><font color="red"><b>*</b></font>帐号：</td>
                                                        <td width="25%"><input class="text" placeholder="必填,唯一验证" name="userLoginName" value="${user.userLoginName }"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="8%"><font color="red"><b>*</b></font>密码：</td>
                                                        <td width="25%"><input type="password" class="text" placeholder="必填" name="userPwd" value="${user.userPwd }"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>性别：</td>
                                                        <td><input  type="radio" name="sex" checked="${user.sex='男'?'checked':'' }"/>男
				                            <input  type="radio" name="sex"  checked="${user.sex='女'?'checked':'' }"/>女</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>年龄：</td>
                                                        <td><input class="text" value="${user.userAge }" name="userAge" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>身份证号：</td>
                                                        <td><input class="text" value="${user.cardId }" name="cardId" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td>电话：</td>
                                                        <td><input class="text" value="${user.tel }" name="tel" /></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>地址：</td>
                                                        <td><input class="text" value="${user.address }" name="address" /></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>入职时间：</td>
                                                        <td><input class="text" value="${user.enterTime }" name="enterTime" /></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>离职时间：</td>
                                                        <td><input class="text" value="${user.leaveTime }" name="leaveTime" } /></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>状态：</td>
                                                        <td><select style="width:55px" name="state">
                                                            	<option  selected=" ${user.state='0'?'selected':'' }" value="0" >禁用</option>
                                                                <option selected="${user.state='1'?'selected':''}" value="1">启用</option>
                                                            </select></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                         <td colspan="2" align="center">
															<input class="btn" onclick="" type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
															<input class="btn" onclick="javascript:history.back(-1);" type="button" value="返回" />
														</td>
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
                        <!-- 展示详情结束 -->
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
                                
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="${pageContext.request.contextPath}/static/Images/mail_left_bg.gif">
                    <img src="${pageContext.request.contextPath}/static/Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif">
                    <img src="${pageContext.request.contextPath}/static/Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="${pageContext.request.contextPath}/static/Images/mail_right_bg.gif">
                    <img src="${pageContext.request.contextPath}/static/Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
    </body>
</html>