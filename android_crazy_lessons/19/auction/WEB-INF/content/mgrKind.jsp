<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2010, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>������������</title>
</head>
<body>
<table width="780" align="center" 
	cellspacing="0" background="images/bodybg.jpg">
<tr>
<td>
<br />
<table width="80%" align="center" cellpadding="0"
	cellspacing="1" style="border:1px solid black">
<tr>
	<td colspan="2" ><div class="mytitle">��ǰ����Ʒ�������£�</div></td> 
</tr>
<s:iterator id="kind" value="kinds" status="st">
<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
<td>������</td>
<td><s:property value="kindName"/></td>
</tr>
<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
<td>��������</td>
<td><s:property value="kindDesc"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
<tr>
<td>
<br />
<h3>���������</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="proAddKind">
<s:textfield name="name" label="������"/>
<s:textfield name="desc" label="��������"/>
<s:textfield name="vercode" label="��֤��"/>
<s:submit value="���"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg">
</div>
</td>
</tr>
</table>
</body>
</html>