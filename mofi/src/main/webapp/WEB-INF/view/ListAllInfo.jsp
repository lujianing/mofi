<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript"
	src="<%=request.getContextPath()%>/script/jquery.min.js"></script>
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
<script type="text/javascript">


function del(id){
$.ajax( {
	type : "POST",
	url : "<%=request.getContextPath()%>/deleteMessage?id=" + id,
			dataType : "json",
			success : function(data) {
				if (data.del == "true") {
					alert("删除成功！");
					$("#" + id).remove();
					$("#" + id + "hr").remove();
				} else {
					alert("删除失败！");
				}
			},
			error : function() {
				alert("网络连接出错！");
			}
		});
	}

	var checkflag = "false";
	function check(fieldName) {
		var field = document.getElementsByName(fieldName);
		if (checkflag == "false") {
			for (i = 0; i < field.length; i++) {
				field[i].checked = true;
			}
			checkflag = "true";
			return "全不选";
		} else {
			for (i = 0; i < field.length; i++) {
				field[i].checked = false;
			}
			checkflag = "false";			
			return "全选";
		}
	}
</script>
</head>
<body>
	<p>&nbsp;</p>
	<table width="529" border="0" align="center">
		<tr>
			<td width="523"><div align="center">
					<span class="STYLE5">接受信息记录</span>
				</div></td>
		</tr>
	</table>
	
	<p>&nbsp;</p>
	
	<form name="form1" method="post" action="updateStateAll?state=pass">
		<table width="486" border="0" align="center">
        <tr>
          <td width="140"><label>
            <div align="right">清空消息记录</div>
          </label></td>
          <td width="119"><label>
            <input type="submit" name="Submit" value="清空消息记录">
          </label></td>
          <td width="213"><a href="ExportToExcelU">导出Excel</a>（请在D盘下查找）</td>
        </tr>
      </table>
	
	<table width="860" border="0" align="center">
		<tr bgcolor="#CCCCCC">
			<td width="70"><input type=button value="全选"
				onClick="this.value=check('list')"></td>
			<td width="76"><span class="STYLE4">信息编号</span></td>
			<td width="294"><span class="STYLE4">信息内容</span></td>
			<td width="70"><span class="STYLE4">用户名</span></td>
			<td width="100"><span class="STYLE4">用户编号</span></td>
			<td width="100"><span class="STYLE4">发送日期</span></td>
			<td width="120"><span class="STYLE4">操作</span></td>
		</tr>
		<%
	 			PageBean pagebean =(PageBean)request.getAttribute("pagebean");
	 			ArrayList<Message> lists =(ArrayList<Message>)pagebean.getList();
	 			for(int i=0;i<lists.size();i++){
	 				Message message = lists.get(i);
	 		%>	
	 			
	 		
			<tr id="<%=message.getId() %>" height="100">
				<td height="50"><span class="STYLE4"> 
				  <input type="checkbox"
						name="list" value="<%=message.getId() %>" />
			  </span></td>
				<td height="50"><%=message.getId() %></td>
				<td height="50"><label>
				  <textarea name="textarea" cols="40" rows="3" disabled="disabled" ><%=message.getMessage() %></textarea>
				</label></td>
				<td height="50"><%=message.getName() %></td>
				<td height="50"><%=message.getUserid() %></td>
				<td height="50"><%=message.getTime() %></td>
				<td height="50"><input type="button"
					onclick="del(<%=message.getId() %>)" value="删除" />
			  </td>
			</tr>
			<tr id="<%=message.getId() %>hr">
				<td colspan="7"><hr /></td>
			</tr>

			<%	
	 			}
	 		
	 	    %>
	</table>
	</form>	
	<div align="center">
	共<font color="red"><c:out value="${pagebean.allRow}"/> </font>条记录   
　　　　		当前第<font color="red"><c:out value="${pagebean.currentPage}"/></font>页  
　　　　  		共<font color="red"><c:out value="${pagebean.totalPage}"/> </font> 页<br/>
			<%
				if(pagebean.getCurrentPage()==1){
			%>
　　　　　　	第一页 上一页  
　　　　		<% }else{%>
　　　　		 
　　　　　　		<a href="listAllInfo?page=1">第一页</a>  
　　　　　　		<a href="listAllInfo?page=<%=pagebean.getCurrentPage()-1 %>">上一页</a>  
　　　　		<% }%> 
　　　　		<% if(pagebean.getCurrentPage() != pagebean.getTotalPage()){ %>
　　　　　　	<a href="listAllInfo?page=<%=pagebean.getCurrentPage()+1 %>">下一页</a>  
　　　　　　	<a href="listAllInfo?page=<%=pagebean.getTotalPage() %>"/>最后一页</a>  
　　　　		<% }else{%>  
　　　　		  
　　　　　　		下一页 最后一页  
　　　　		<%} %>
	</div>

</body>