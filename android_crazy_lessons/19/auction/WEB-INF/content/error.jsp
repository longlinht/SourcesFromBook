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
<title>������ʾҳ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr> 
	<td height="39" valign="top">
		<div align="center" style="font-size:11pt;color:red;font-weight:bold">
			ϵͳ��������з�����һ��������Ϣ���£�</div>
	</td>
</tr>
<tr>
	<td height="100">
		<center>
		<div class="error"><br /><br />
			<s:property value="errMsg"/>
		</div>
		</center>
	</td>
</tr>
<tr>
<td><div align="center" style="font:10pt">�����Ⱥ˶����룬
	����ٴγ��ָô������¼<a href="http://www.crazyit.org">���Java����</a>�ύ������Ϣ</div><br></td>
</tr>
</table>
</body>
</html>