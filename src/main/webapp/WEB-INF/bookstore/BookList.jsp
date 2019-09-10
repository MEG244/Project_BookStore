<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../tagsIn.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookList</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/ListStyle.css" />
<script type="text/javascript" src ="${pageContext.request.contextPath}/resources/js/searchScript.js"></script>
</head>
<body>
<div>
	<b text-align="right"><a href="list.bsmall">장바구니</a></b>
	<c:if test="${sessionScope.loginfo.id == null}">
	<b>로그인 하지 않았습니다.</b> <br>
	</c:if>
	<c:if test="${sessionScope.loginfo.id != null}">
	접속자 아이디 : ${sessionScope.loginfo.id} <br>
	</c:if>
	<form action="list.bs">
		<select name="category">
			<option value="title">정확도</option>
			<option value="pub_date">신상품</option>
			<option value="price">가격</option>
		</select>
		<input type="hidden" value="${keyword }" name="keyword">
		<input type="hidden" value="sorting" name="sorting">
		<input type="submit" value="정렬">
	</form>
</div>

<c:choose>
	<c:when test="${totalCount == 0 }">
		<div>찾으시는 책이 없습니다</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${bookLists }" var="book">
			<div style="border: 1px solid gold; float: left; width: 13%; height: 20%; padding:10px;">
				<div class = "pic"><div class = "image" ><a href = "#">
				<img id="bookImage${book.bnum }" src='<c:url value="/resources/Img/${book.title}.jpg"/>' width="130" height="200"></a></div>
				
				<div id = "myMouseEnter${book.bnum }" class ="mouse_Enter">
						<div class ="mouse_Enter_contents" style="width: 250;">
						제목: ${book.title } <br>
						저자: ${book.author }<br>
						출판사: ${book.publisher } <br>
						출판년도: ${book.pub_date }<br>
						분류: ${book.category }<br>
						</div>
					</div>
				<div id = "myModal${book.bnum }" class="modal">
					<div class="modal-content">
						<img src = "${pageContext.request.contextPath}/resources/Img/${book.title}.jpg" width =150 height =200><br>
							제목: ${book.title } <br>
							저자: ${book.author } <br>
							출판사: ${book.publisher } <br>
							출판년도: ${book.pub_date }<br>
							책소개: ${book.page } page, <br>
							${book.introduce } <br>
							분류: ${book.category } <br>
							재고: ${book.stock } <br>
							<a href="detail.bs?bnum=${book.bnum }"><button>상세 보기</button></a>
							<span id="close" onclick="span_close(${book.bnum})"><input type="button" value="닫기"  style="width:100px;"></span>
					</div>
				</div>
				</div>
				<center><a href="#" onclick="modEvt('${book.bnum }')">${book.title }</a></center>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>

	<br><br>
</body>
	<center>${pageInfo.pagingHtml}</center>
</html>