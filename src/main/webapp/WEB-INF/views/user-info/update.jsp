<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h3>회원 정보 수정</h3>
<form action="/user-info/update" method="POST">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum}">
	<input type="text" name="uiId" value="${userInfo.uiId}"><br>
	<input type="password" name="uiPwd" value="패스워드"><br>
	<input type="text" name="uiName" value="${userInfo.uiName}"><br>
	<button>수정</button>
</form>
</body>
</html>