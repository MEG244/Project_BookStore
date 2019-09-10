<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../tagsIn.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td><img src='<c:url value="/resources/Img/${book.title}.jpg"/>'></td>
		
		<td>
			<form action="add.bsmall" method="post">
				<table>
					<tr>
						<td><h1>${book.title }</h1></td>
					</tr>
					<tr>
						<td>${book.category} </td>
					</tr>
					<tr>
						<td>${book.author} 지음 | ${book.publisher }</td>
					</tr>
					<tr>
						<td>${book.pub_date} 출간 </td>
					</tr>
					<tr>
						<td>리뷰 : </td>
					<input type="hidden" name="bnum" value="${book.bnum}">
					</tr>
					<tr>
						<td>가격 : <h3>${book.price }원</h3> </td>
					</tr>
					<tr>
						<td>주문 수량 <input type="number" name="quantity" value=1></td>
					</tr>
					<tr>
						<td><input type="submit" value="주문하기"></td>
					</tr>
				</table><br>
			</form>
		책소개: <br>
		${bookIntroduce }
		<br><br>
		
		</td>
	</tr>


</table>


</body>
</html>