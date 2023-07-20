<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>설명</th>
	</tr>
<%
List<Map<String, String>> classInfoList = (List<Map<String, String>>)request.getAttribute("classInfoList");
for(Map<String, String> classInfo : classInfoList){
%>
	<tr>
		<td><%=classInfo.get("ciNum")%></td>
		<td><a href="/class-info/view?ciNum=<%=classInfo.get("ciNum")%>"><%=classInfo.get("ciName")%></td>
		<td><%=classInfo.get("ciDesc")%></td>
	</tr>
<%	
}
%>
</table>
</body>
</html>