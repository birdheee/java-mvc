<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리스트</title>
</head>
<body>
<h3>영화 리스트</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>장르</th>
		<th>개봉일</th>
		<th>관객수</th>
	</tr>
	<c:forEach items="${movieInfoList}" var="movieInfo">
	<tr>
		<td>${movieInfo.miNum}</td>
		<td><a href="/movie-info/view?miNum=${movieInfo.miNum}">${movieInfo.miTitle}</td>
		<td>${movieInfo.miGenre}</td>
		<td>${movieInfo.miCredat}</td>
		<td>${movieInfo.miCnt}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="right"><button onclick="location.href='/movie-info/insert'">등록</button></td>
	</tr>
</table>
</body>
</html>