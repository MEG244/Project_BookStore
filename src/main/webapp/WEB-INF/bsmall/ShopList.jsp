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
갯수 : ${fn:length(lists) }<br>

<a href="logout.jsp">로그아웃</a>
<br><br>
	<h2 align="center">주문 내역</h2>
	<table border="1" align="center">
		<tr>
			<td colspan="3" align="center">
				주문자 정보 : ${sessionScope.loginfo.name}(${sessionScope.loginfo.id})
			</td>
		</tr>	
		<tr>
			<th>주문 번호</th>
			<th>주문 일자</th>
			<th>상세 보기</th>
		</tr>
		<c:forEach items="${lists}" var="shopinfo">
			<tr>
				<td align="center">
					${shopinfo.oid}
				</td>				
				<td align="center">
					${shopinfo.orderdate}
				</td>
				<td align="center">
					<a href="detailview.bsmall?pmkey=${shopinfo.oid}">상세 보기</a> <!-- pmkey=주문번호 -->  
					<!-- detailview.mall => DetailViewController -->
				</td>				
			</tr>
		</c:forEach>		
	</table>		
</body>
</html> 










