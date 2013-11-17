<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	color: #00FFFF;
	font-weight: bold;
}
.STYLE2 {font-size: 24px}
-->
</style>
</head>
<% boolean isListen =Boolean.valueOf(request.getParameter("isListen")); %>
<body>
<div align="center" class="STYLE1">监听设置</div><br/>
<div align="center">

</div>

<table width="401" height="75" border="0" align="center">
  <tr bgcolor="#CCCCCC">
    <td width="192"><div align="center"><a href="/mofi/ListenInfo" class="STYLE2">开启信息监听</a></div></td>
    <td width="193"><div align="center"><a href="/mofi/StopListen" class="STYLE2">关闭信息监听</a></div></td>
  </tr>
</table>
</body>
</html>
