<%@page import="kr.co.ezenac.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*속성저장*/
	pageContext.setAttribute("ezenInteger", 1019);
	pageContext.setAttribute("ezenString", "페이지 역역의 문자열");
	pageContext.setAttribute("pagePerson", new Person("이순신", 67));
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 영역</title>
</head>
<body>
	<h2>page 영역의 속성값 읽기</h2>
	<%
		int pInteger = (Integer)(pageContext.getAttribute("ezenInteger"));
		String pString = pageContext.getAttribute("ezenString").toString();
		Person person = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	
	<ul>
		<li>Integer 객체: <%=pInteger %></li>
		<li>String 객체: <%=pString %></li>
		<li>Person 객체: <%=person %></li>
	</ul>
	
	<h2>Include된 파일에서 page 영역 읽어오기</h2>
	<%@ include file="pageContextInclude.jsp" %>
	<a href="pageContextlocation.jsp">pageContextlocation.jsp 바로가기</a>
</body>
</html>








