<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<h3>계산기</h3>
<form id="frm" action="/calc/p">
	<input type="text" name="num1">
	<select onchange="changeOp(this)">
		<option value="p">더하기</option>
		<option value="s">빼기</option>
		<option value="m">곱하기</option>
		<option value="d">나누기</option>
	</select>
	<input type="text" name="num2"><br>
	<button>계산</button>
</form>
<script>
function changeOp(obj){
	var action = '/calc/' + obj.value;
	alert(action);
	document.getElementById('frm').action = action;
}
</script>
</body>
</html>