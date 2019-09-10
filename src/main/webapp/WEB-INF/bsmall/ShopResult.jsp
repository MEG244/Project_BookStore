<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="./../tagsIn.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- session 설정 : 계속 상태유지, model은 한 번 사용하고 유지하지 않을 때  -->
<body>
	<h2 align="center">주문 내역</h2>
	<a href="main.jsp">시작페이지</a><br><br>
	
	<table border="1" align="center">
		<tr>
			<td colspan="3" align="center">
				주문자 정보 : ${sessionScope.loginfo.name}(${sessionScope.loginfo.id})
			</td>
		</tr>	
		<tr>
			<th>순번</th>
			<th>상품명(상품번호)</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${lists}" var="result" varStatus="status"> 
			<tr>
				<td align="center">
					${status.count}
				</td>				
				<td align="center">
					${result.pname}($Presult.pnum})
				</td>
				<td align="center">
					${resutl.qty }
				</td>
				<td align="center">
				<fmt:formatNumber value="${result.price}" pattern="###,###"/>
				</td>
				<td align="center">
					<fmt:formatNumber value="${result.amount}" pattern="###,###"/>
				</td>	
			</tr>
		</c:forEach>		
	</table>		


</body>
</html>