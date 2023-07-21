<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세보기</title>
</head>
<body>
<%
Map<String, String> userInfo = (Map<String, String>)request.getAttribute("selectUserInfo");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=userInfo.get("uiNum") %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=userInfo.get("uiName") %></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td><%=userInfo.get("uiId") %></td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td><%=userInfo.get("uiPwd") %></td>
	</tr>
</table>

</body>
</html>