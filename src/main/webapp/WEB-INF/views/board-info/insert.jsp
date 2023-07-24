<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
<form action="/board-info/insert" method="POST">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="biTitle"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="biTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="biContent" style="resize:none" cols="30" rows="15"></textarea></td>
		</tr>
		<tr>
			<th colspan="2" align="right"><button>등록</button></th>
		</tr>
	</table>
</form>
</body>
</html>