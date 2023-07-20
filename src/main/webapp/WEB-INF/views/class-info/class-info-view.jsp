<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Map<String, String> classInfo = (Map<String, String>)request.getAttribute("classInfo");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=classInfo.get("ciNum")%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=classInfo.get("ciName")%></td>
	</tr>
	<tr>
		<th>설명</th>
		<td><%=classInfo.get("ciDesc")%></td>
	</tr>
</table>
</body>
</html>