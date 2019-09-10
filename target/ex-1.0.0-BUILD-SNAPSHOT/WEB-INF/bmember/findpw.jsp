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
findpw.jsp<br>
<h1>이메일로 비밀번호 찾기</h1>
<form:form commandName="bmember" action="findpw.bm" method="post">

	 
	 	<input type="text" name="id" placeholder="아이디">
		<form:errors cssClass="err" path="id"></form:errors>
		
	 <br><br>
	 
		<input type="text" name="name" placeholder="이름">
		<form:errors cssClass="err" path="name"></form:errors>
		
	<br><br>	
	
		<input type="text" name="eamil1" placeholder="이메일"> @
		<select name="email2">
			<option value="">선택하세요</option> 
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>			
			<option value="nate.com">nate.com</option>			
			<option value="gmail.com">gmail.com</option>			
		</select>
		<form:errors cssClass="err" path="eamil1"></form:errors>
		
	<br><br>
	
	<input type="submit" value="확인">
	
</form:form>
</body>
</html>