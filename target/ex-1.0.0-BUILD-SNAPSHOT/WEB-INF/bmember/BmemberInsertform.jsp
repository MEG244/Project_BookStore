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
BmemberInsertForm.jsp<br>
<h1>회원 가입</h1>
<form:form commandName="bmember" action="insert.bm" method="post">

	아이디 : 
		<input type="text" name="id" value="아이디">
		<form:errors cssClass="err" path="id"></form:errors>
	<br><br>
	
	비밀번호 : 
		<input type="password" name="pw" value="1234">
		<form:errors cssClass="err" path="pw"></form:errors>
	<br><br>
	
	비밀번호 확인 : 
		<input type="password" name="pwc" value="1234">
		<form:errors cssClass="err" path="pwc"></form:errors>
	<br><br>

	이름 : 
		<input type="text" name="name" value="이름">
		<form:errors cssClass="err" path="name"></form:errors>
	<br><br>
	
	생년월일 : 
		<input type="text" name="birth" value="20011030"> "-" 제거후 입력해주세요 예)19990103
		<form:errors cssClass="err" path="birth"></form:errors>
	<br><br>
	
	핸드폰번호 : 
	
		<select name = "pn1">
			<option value="">선택하세요</option> 
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="019">019</option>
		</select>
		
		- <input type="text" name="pn2" value="1111">
		- <input type="text" name="pn3" value="2222">
		<form:errors cssClass="err" path="pn1"></form:errors>
		<form:errors cssClass="err" path="pn2"></form:errors>
		<form:errors cssClass="err" path="pn3"></form:errors>
	<br><br>
	
	이메일 : 
		<input type="text" name="email1" value=""> @ 		
		<select name="email2">
			<option value="">선택하세요</option> 
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>			
			<option value="nate.com">nate.com</option>			
			<option value="gmail.com">gmail.com</option>			
		</select>
		<form:errors cssClass="err" path="email1"></form:errors>
		<form:errors cssClass="err" path="email2"></form:errors>
	<br>
	
	<p>
		<label for="gender"></label>
		성별 :<input type="radio" name="gender" value="남">남
		<input type="radio" name="gender" value="여">여		
		<form:errors cssClass="err" path="gender"></form:errors>
	</p>	
	
	<p>
		<label for="genre"></label>
		관심장르 :<input type="checkbox" name="genre" value="미스테리">미스테리
		<input type="checkbox" name="genre" value="로맨스">로맨스
		<input type="checkbox" name="genre" value="판타지">판타지
	
		<form:errors cssClass="err" path="genre"></form:errors>
	</p>			
	
	<input type="submit" value="추가하기">
	
</form:form>
</body>
</html>



