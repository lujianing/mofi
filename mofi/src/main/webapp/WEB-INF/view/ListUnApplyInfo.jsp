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
function update(id){
	window.location.href="<%=request.getContextPath() %>/updateInput?id="+id;
}

function del(id){
$.ajax( {
	type : "POST",
	url : "<%=request.getContextPath()%>/deleteApplyInfo?id=" + id,
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
					<span class="STYLE5">等待审核信息</span>
				</div></td>
		</tr>
	</table>
	
	<p>&nbsp;</p>
	
	<form name="form1" method="post" action="updateStateAll?state=pass">
		<table width="486" border="0" align="center">
        <tr>
          <td width="140"><label>
            <div align="right">提交审核信息：</div>
          </label></td>
          <td width="119"><label>
            <input type="submit" name="Submit" value="提交选中项">
          </label></td>
          <td width="213"><a href="ExportToExcelU?type=un">导出Excel</a>（请在D盘下查找）</td>
        </tr>
      </table>
	
	<table width="860" border="0" align="center">
		<tr bgcolor="#CCCCCC">
			<td width="70"><input type=button value="全选"
				onClick="this.value=check('list')"></td>
			<td><span class="STYLE4">订货编号</span></td>
			<td width="100"><span class="STYLE4">货物编号</span></td>
			<td width="70"><span class="STYLE4">货物数量</span></td>
			<td width="100"><span class="STYLE4">门店编号</span></td>
			<td width="100"><span class="STYLE4">订货人</span></td>
			<td width="100"><span class="STYLE4">订货日期</span></td>
			<td width="100"><span class="STYLE4">订货状态</span></td>
			<td width="120"><span class="STYLE4">操作</span></td>
		</tr>
		<%
	 			PageBean pagebean =(PageBean)request.getAttribute("pagebean");
	 			ArrayList<ApplyInfo> lists =(ArrayList<ApplyInfo>)pagebean.getList();
	 			for(int i=0;i<lists.size();i++){
	 				ApplyInfo applyinfo = lists.get(i);
	 		%>	
	 			
	 		
			<tr id="<%=applyinfo.getId() %>">
				<td><span class="STYLE4"> <input type="checkbox"
						name="list" value="<%=applyinfo.getId() %>" />
				</span></td>
				<td><%=applyinfo.getId() %></td>
				<td><%=applyinfo.getHwbh() %></td>
				<td><%=applyinfo.getHwsl() %></td>
				<td><%=applyinfo.getMdbh() %></td>
				<td><%=applyinfo.getName() %></td>
				<td><%=applyinfo.getTime() %></td>
				<td><%=applyinfo.getState() %></td>
				<td><input type="button"
					onclick="del(<%=applyinfo.getId() %>)" value="删除" />
					&nbsp;&nbsp; <input type="button"
					onclick="update(<%=applyinfo.getId() %>)" value="更新" /></td>
			</tr>
			<tr id="<%=applyinfo.getId() %>hr">
				<td colspan="9"><hr /></td>
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
　　　　		 
　　　　　　		<a href="listUnApplyInfo?page=1">第一页</a>  
　　　　　　		<a href="listUnApplyInfo?page=<%=pagebean.getCurrentPage()-1 %>">上一页</a>  
　　　　		<% }%> 
　　　　		<% if(pagebean.getCurrentPage() != pagebean.getTotalPage()){ %>
　　　　　　	<a href="listUnApplyInfo?page=<%=pagebean.getCurrentPage()+1 %>">下一页</a>  
　　　　　　	<a href="listUnApplyInfo?page=<%=pagebean.getTotalPage() %>"/>最后一页</a>  
　　　　		<% }else{%>  
　　　　		  
　　　　　　		下一页 最后一页  
　　　　		<%} %>
	</div>

</body>