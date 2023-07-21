<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:forEach items="${classInfoList}" var="classInfo">
	<tr>
		<td>${classInfo.ciNum}</td>
		<td><a href="/class-info/view?ciNum=${classInfo.ciNum}">${classInfo.ciName}</td>
		<td>${classInfo.ciDesc}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>