<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  	function changeValidateCode(obj){
  		var timeNow = new Date().getTime();
  		obj.src="volidate/service.do?time="+timeNow;
  	}	
  </script>
<style type="text/css">
<!--
.STYLE2 {color: #000000; }
-->
</style>
</head>
<body background="./images/71.jpg">
<form id="form1" name="form1" method="post" action="loginvolidate">
<table width="326" height="241"  align="center" >
  <tr>
    <td width="105"><div align="right" class="STYLE2">飞信帐号：</div></td>
    <td width="205"><label>
      <input type="text" name="username" />
    </label></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE2">飞信密码：</div></td>
    <td><label>
      <input type="password" name="password" />
    </label></td>
  </tr>
  <tr>
    <td><div align="right" class="STYLE2">验证码：</div></td>
    <td><label>
      <input type="text" name="volidate" />
    </label></td>
  </tr>
  <tr>
    <td><label>
      <div align="right">
        <input type="submit" name="Submit" value="登录" />
        </div>
    </label></td>
    <td><img  src= "volidate/service.do" onClick="changeValidateCode(this)" title="刷新验证码" style="cursor: hand;" /></td>
  </tr>
</table>
</form>
</body>
</html>