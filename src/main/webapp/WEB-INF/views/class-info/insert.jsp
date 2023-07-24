<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 등록</title>
</head>
<body>
<h3>과목 등록</h3>
<form action="/class-info/insert" method="POST">
	<input type="text" name="ciName" placeholder="과목 이름"><br>
	<textarea name="ciDesc" placeholder="설명" style="resize:none" cols="30" rows="15"></textarea><br>
	<button>등록</button>
</form>
</body>
</html>