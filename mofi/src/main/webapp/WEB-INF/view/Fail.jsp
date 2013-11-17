<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.solosky.litefetion.bean.VerifyImage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
失败
	<% VerifyImage image = (VerifyImage)session.getAttribute("image"); %>
	<%=image.getSessionId() %><br>
	<%=image.getVerifyCode() %><br>
	<%=image.getVerifyType() %><br>
	<%=image.getClass() %>
	<a href="/mofi/Test">点我刷新</a>
</body>
</html>