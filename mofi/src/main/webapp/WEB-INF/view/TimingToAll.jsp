<%@ page language="java" contentType="text/html; charset=UTF-8" 
	import="net.solosky.litefetion.LiteFetion,
	java.util.Iterator,
	net.solosky.litefetion.bean.Buddy,
	net.solosky.litefetion.bean.Cord"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功！</title>
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
function sendinfos(){
    document.forms.form.action="TimingsendInfos";
    document.forms.form.submit();
}

function sendinfo(userid){
    document.form.action="sendInfo?userid="+userid;
    document.form.submit();
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
					<span class="STYLE5">定时群发</span>
				</div></td>
		</tr>
	</table>
	
	<form name="form" method="post" action="">
	  <table width="795" border="0" align="center">
        <tr>
          <td width="54"><input type=button value="全选"
				onClick="this.value=check('list')"></td>
          <td width="277"><label>
            消息设定：
                <input type="text" name="messages">
          </label></td>
          <td width="263">时间设定
            <label>
            <input type="text" name="textfield">时间格式：2012-04-15 09:45:30
          </label></td>
          <td width="183"><label>
            <input type="button" onclick="sendinfos();" name="Submit" value="发送至选中项">
          </label></td>
        </tr>
      
      </table>

	<p>&nbsp;</p>
 <%!
 	LiteFetion client=null;
 %>
<%
//默认分组
	client = (LiteFetion)session.getAttribute("client");

%>


<table width="800" border="0" align="center">
  <tr>
    <td colspan="6" bgcolor="#999999"><div align="center">默认分组</div></td>
  </tr>
  <%
      Iterator<Buddy> bit = client.getBuddyListWithoutCord().iterator();
      while(bit.hasNext()) {
      	Buddy buddy = bit.next();
      %>
  <tr>
    <td>
      <input type="checkbox" name="list" value="<%=buddy.getUserId() %>">
    </td>
    <td><%=buddy.getDisplayName() %></td>
    <%
        if(buddy.getState().toString().equals("SMS")){
       %>
    <td>[短信在线]</td>
    <%
        }
        if(buddy.getState().toString().equals("OFFLINE")){
       %>
    <td>[离线]</td>
    <%
        }
        if(buddy.getState().toString().equals("ONLINE")){
       %>
    <td>[在线]</td>
    <%} %>
    <td><%=buddy.getMobile() %></td>
    <td><label>
      <input type="text" name="message<%=buddy.getUserId() %>">
    </label></td>
    <td><label>
      <input  type="submit" onClick="sendinfo(<%=buddy.getUserId() %>);" value="发送">
    </label></td>
  </tr>
  <tr>
    <td colspan="6"><hr></td>
  </tr>
  <%} %>
</table>

<%
 Iterator<Cord> cit = client.getCordList().iterator();
 while(cit.hasNext()) {
 	Cord cord = cit.next();
 
 %>
 <table width="800" border="0" align="center">
   <tr>
     <td colspan="6" bgcolor="#999999"><div align="center"><%=cord.getId() %>::<%=cord.getTitle() %></div></td>
   </tr>
   <%
      bit = client.getBuddyListByCord(cord).iterator();
  	while(bit.hasNext()) {
  		Buddy buddy = bit.next();
  	
      
      %>
   <tr>
     <td><label>
       <input type="checkbox" name="list" value="<%=buddy.getUserId() %>">
     </label></td>
     <td><%=buddy.getDisplayName() %></td>
     <%
        if(buddy.getState().toString().equals("SMS")){
       %>
     <td>[短信在线]</td>
     <%
        }
        if(buddy.getState().toString().equals("OFFLINE")){
       %>
     <td>[离线]</td>
     <%
        }
        if(buddy.getState().toString().equals("ONLINE")){
       %>
     <td>[在线]</td>
     <%} %>
     <td><%=buddy.getMobile() %></td>
     <td><label>
       <input type="text" name="message<%=buddy.getUserId() %>">
     </label></td>
     <td><label>
       <input  type="button" onClick="sendinfo(<%=buddy.getUserId()%>);" value="发送信息">
     </label></td>
   </tr>
   <tr>
     <td colspan="6"><hr></td>
   </tr>
   <%} %>
 </table>
 <%} %>
 
 </form>   
     
</body>


</html>