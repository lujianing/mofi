<%@ page language="java" contentType="text/html; charset=UTF-8" import="qianyan.mofi.bean.PageBean"
    pageEncoding="UTF-8"%>
       <%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		
	 		<%
	 			PageBean pagebean =(PageBean)request.getAttribute("pagebean");
	 			ArrayList<ApplyInfo> lists =(ArrayList<ApplyInfo>)pagebean.getList();
	 			for(int i=0;i<lists.size();i++){
	 				ApplyInfo applyinfo = lists.get(i);
	 		%>	
	 			<c:out value="<%=applyinfo.getState() %>"></c:out><br>
	 		<%	
	 			}
	 		
	 	    %>
	 		
　　　　		共<font color="red"><c:out value="${pagebean.allRow}"/> </font>条记录   
　　　　		当前第<font color="red"><c:out value="${pagebean.currentPage}"/></font>页  
　　　　  		共<font color="red"><c:out value="${pagebean.totalPage}"/> </font> 页<br/>
			<%
				if(pagebean.getCurrentPage()==1){
			%>
　　　　　　	第一页 上一页  
　　　　		<% }else{%>
　　　　		 
　　　　　　		<a href="testPage?page=1">第一页</a>  
　　　　　　		<a href="testPage?page=<%=pagebean.getCurrentPage()-1 %>">上一页</a>  
　　　　		<% }%> 
　　　　		<% if(pagebean.getCurrentPage() != pagebean.getTotalPage()){ %>
　　　　　　	<a href="testPage?page=<%=pagebean.getCurrentPage()+1 %>">下一页</a>  
　　　　　　	<a href="testPage?page=<%=pagebean.getTotalPage() %>"/>最后一页</a>  
　　　　		<% }else{%>  
　　　　		  
　　　　　　		下一页 最后一页  
　　　　		<%} %>
　　　　		
			</div>
</body>
</html>