<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../tagsIn.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

접속자 아이디 : ${sessionScope.loginfo.id} <br>

<h2 align="center">주문 내역</h2>
	<c:if test="${sessionScope.totalAmount==0}">
		<b style="text-align: center">주문내역이 없습니다.</b>
	</c:if>
	<c:if test="${sessionScope.totalAmount!=0 }">
	<table border="1" align="center">
		<tr>
			<td colspan="5" align="center">
				주문자 정보 : ${sessionScope.loginfo.name}(${sessionScope.loginfo.id})
			</td>
		</tr>	
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>주문 수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${sessionScope.shopLists}" var="shopinfo"> 
			<tr>
				<td align="center">
					${shopinfo.bnum}
				</td>				
				<td align="center">
					${shopinfo.pname}
				</td>
				<td align="center">
					${shopinfo.qty}
				</td>				
				<td align="center">
					${shopinfo.price}
				</td>
				<td align="center">
					${shopinfo.amount}
				</td>				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<a href="calculate.bsmall">결재하기</a> <!-- calculate.mall => CartCalculateController--> 
				&nbsp;&nbsp; 
				<a href="list.bs">추가 주문</a>
			</td>
			<td colspan="2" align="center">총 금액 : ${sessionScope.totalAmount}</td> 
		</tr>
		
	</table>	
	</c:if>
	<br><br><br>	
</body>
</html> 




