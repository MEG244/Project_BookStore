<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	session = request.getSession(true); 
	String id = request.getParameter("id"); 
	request.getSession().setAttribute("id", id); 
%>  

${sessionScope.id}�� �ȳ��ϼ���

<b><a href="<%=request.getContextPath()+"/order.bsmall"%>">�ֹ����� ����</a></b>


