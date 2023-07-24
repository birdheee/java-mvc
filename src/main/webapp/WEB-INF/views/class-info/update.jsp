<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 정보 수정</title>
</head>
<body>
<h3>과목 정보 수정</h3>
<form action="/class-info/update" method="POST">
<input type="hidden" name="ciNum" value="${classInfo.ciNum}">
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="ciName" value="${classInfo.ciName}"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><textarea name="ciDesc" style="resize:none" cols="30" rows="15">${classInfo.ciDesc}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><button>수정 완료</button></td>
		</tr>
	</table>
</form>
</body>
</html>