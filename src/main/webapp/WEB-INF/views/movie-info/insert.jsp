<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
</head>
<body>
<h3>영화 등록</h3>
<form action="/movie-info/insert" method="POST">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="miTitle"></td>
		</tr>
		<tr>
			<th>장르</th>
			<td>
				<select name="miGenre">
					<option value="장르">장르</option>
					<option value="코미디">코미디</option>
					<option value="액션">액션</option>
					<option value="S/F">S/F</option>
					<option value="드라마">드라마</option>
					<option value="멜로">멜로</option>
					<option value="스릴러">스릴러</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>개봉일</th>
			<td><input type="date" name="miCredat"></td>
		</tr>
		<tr>
			<th>관객수</th>
			<td><input type="number" name="miCnt"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="miContent" style="resize:none" cols="30" rows="15"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><button>등록</button></td>
		</tr>
	</table>
</form>
</body>
</html>