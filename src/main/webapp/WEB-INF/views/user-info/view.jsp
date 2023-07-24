<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세보기</title>
</head>
<body>
<form action="/user-info/delete" method="POST">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum}">
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${userInfo.uiNum}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${userInfo.uiName}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${userInfo.uiId}</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td>${userInfo.uiPwd}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'" type="button">수정</button>
				<button>삭제</button> <!-- type이 디폴트로 submit이기 때문에 form action에 영향을 받음 -->
			</th>
		</tr>
	</table>
</form>
</body>
</html>