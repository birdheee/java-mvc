<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세보기</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${movieInfo.miNum}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${movieInfo.miTitle}</td>
	</tr>
	<tr>
		<th>장르</th>
		<td>${movieInfo.miGenre}</td>
	</tr>
	<tr>
		<th>개봉일</th>
		<td>${movieInfo.miCredat}</td>
	</tr>
	<tr>
		<th>관객수</th>
		<td>${movieInfo.miCnt}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${movieInfo.miContent}</td>
	</tr>
</table>
</body>
</html>