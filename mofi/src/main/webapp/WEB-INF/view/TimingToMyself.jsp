<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
<!--
.STYLE4 {
	color: #000000;
	font-size: 14px;
}

.STYLE5 {
	font-size: 36px;
	color: #00CC00;
}
-->
</style>

</head>
<body>
	<p>&nbsp;</p>
	<table width="529" border="0" align="center">
		<tr>
			<td width="523"><div align="center">
					<span class="STYLE5">定时提醒</span>
				</div></td>
		</tr>
	</table>
	
	<p>&nbsp;</p>
	
	<form name="form1" method="post" action="sendtomyself">
	  <table width="370" height="154" border="0" align="center">
        <tr>
          <td height="75"><label>
            <div align="center">
              <textarea name="message" cols="30" rows="4"></textarea>
              </div>
          </label></td>
        </tr>
        <tr>
          <td height="38"><div align="center">
            <label>
            设定时间：时间格式为：2012-04-15 09:45:30
            <input type="text" name="time">
            </label>
          </div></td>
        </tr>
        <tr>
          <td height="33"><div align="center">
            <label>
            <input type="submit" name="Submit" value="定时提醒">
            </label>
          </div></td>
        </tr>
      </table>
	</form>	
</body>