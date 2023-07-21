<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:forEach items="${userInfoList}" var="userInfo">
	<tr>
		<td>${userInfo.uiNum}</td>
		<td><a href="/user-info/view?uiNum=${userInfo.uiNum}">${userInfo.uiName}</td>
		<td>${userInfo.uiId}</td>
		<td>${userInfo.uiPwd}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>