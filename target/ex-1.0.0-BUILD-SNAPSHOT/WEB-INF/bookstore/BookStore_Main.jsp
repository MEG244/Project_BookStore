<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookStore 메인 페이지</title>\
<script>
	function LogIn(){
		location.href = "login.bm"
	}

</script>

</head>
<body>
<form name="f" action = "list.bs">
	<div id = "Main_cate">
		<div>
		<select id="sel_cateMain" name="category">
			<option value="all">전체</option>
			<option value="title">제목</option>
			<option value="author">저자</option>
			<option value="publisher">출판사</option>
		</select>
		<input type="text" name = "keyword" id = "searchMain" ><br><br>
			<div id = "Main_submit">
			<input type="submit" value="검색">
			</div>
		</div>
	</div>
	
</form>
<div onclick="LogIn()">
로그인
</div>

</body>
</html>