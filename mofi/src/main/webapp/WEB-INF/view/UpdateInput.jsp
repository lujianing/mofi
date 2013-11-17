<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" method="post" action="UpdateApplyInfo">

<table width="500" height="320" border="0" align="center">
  <tr>
    <td colspan="2" bgcolor="#CCCCCC"><div align="center" class="STYLE1">信息修改</div></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3">订单编号:</div></td>
    <td><input type="text" name="id" readonly="readonly" value="${applyinfo.id}"></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3" >货物编号：</div></td>
    <td><label>
      <input type="text" name="hwbh" value="${applyinfo.hwbh}">
    </label></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3">货物数量：</div></td>
    <td><input type="text" name="hwsl" value="${applyinfo.hwsl}"></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3">门店编号：</div></td>
    <td><input type="text" name="mdbh" value="${applyinfo.mdbh}"></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3">订货人：</div></td>
    <td><input type="text" name="name" value="${applyinfo.name}"></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE3">订货号码：</div></td>
    <td><input type="text" name="phone" readonly="readonly" value="${applyinfo.phone}"></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="Submit" value="提交">
      &nbsp;&nbsp;&nbsp;
      <input type="button" name="Submit2" value="返回">
      
    </div></td>
  </tr>
</table>
</form>
</body>
</html>