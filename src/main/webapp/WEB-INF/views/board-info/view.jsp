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
		<td>${boardInfo.biNum}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${boardInfo.biTitle}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${boardInfo.biWriter}</td>
	</tr>
	<tr>
		<th>작성날짜</th>
		<td>${boardInfo.biCredat}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${boardInfo.biCnt}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${boardInfo.biContent}</td>
	</tr>
	<tr>
		<th colspan="2" align="right">
			<button>수정</button>
			<button>삭제</button>
		</th>
	</tr>
</table>
</body>
</html>