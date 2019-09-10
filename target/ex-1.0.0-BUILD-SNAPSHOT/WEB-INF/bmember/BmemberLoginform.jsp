<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../tagsIn.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

</head>
<body>
BmemberLoginForm.jsp<br>
<h1>로고</h1>
<form:form commandName="bmember" action="login.bm" method="post">

	 
		<input type="text" name="id" placeholder="아이디">
		<form:errors cssClass="err" path="id"></form:errors>
		
	<br><br>
	
	
		<input type="password" name="pw" placeholder="패스워드">
		<form:errors cssClass="err" path="pw"></form:errors>
		
	<br><br>
	
	<input type="submit" value="로그인">
	
	<hr>
	
	<a href="findid.bm"><b>아이디찾기</b></a>  | 
	<a href="findpw.bm"><b>비밀번호찾기</b></a>  |
	<a href="insert.bm"><b>회원가입</b></a>
	
</form:form>
</body>
</html>




