<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>패스워드</th>
	</tr>
	
<%
List<Map<String, String>> userInfoList = (List<Map<String, String>>)request.getAttribute("selectUserInfoList");
for(Map<String, String> userInfo : userInfoList){
%>
	<tr>
		<td><%=userInfo.get("uiNum")%></td>
		<td><a href="/user-info/view?uiNum=<%=userInfo.get("uiNum")%>"><%=userInfo.get("uiName")%></td>
		<td><%=userInfo.get("uiId")%></td>
		<td><%=userInfo.get("uiPwd")%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>