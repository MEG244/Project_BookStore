<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	session = request.getSession(true); 
	String id = request.getParameter("id"); 
	request.getSession().setAttribute("id", id); 
%>  

${sessionScope.id}님 안녕하세요

<b><a href="<%=request.getContextPath()+"/order.bsmall"%>">주문내역 보기</a></b>


