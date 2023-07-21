<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>번호 찾기 결과</title>
</head>
<body>
<h3>결과</h3>
<%= request.getAttribute("msg") %><br>
틀린 횟수 : <%= request.getAttribute("cnt") %>
</body>
</html>