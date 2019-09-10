<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책 넣는 곳</title>
</head>
<body>
	<form action="insert.bs" method="post">
		<h2>추가하고 싶은 책의 ISBN을 입력하세요</h2>
		<br><br>
		<input type="text" name="ISBN">
		<input type="submit" value="추가">
	</form>
</body>
</html>