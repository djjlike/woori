<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link href="./css/menu.css" rel="stylesheet">

<style type="text/css">
#main{

margin: 0 auto;
width: 800px;
height: 100%;
}

table{
	width: 100%;
	height: 400px;
	border-collapse: collapse;
	 

}

td{
	border-bottom: 1px solid #6A5ACD;
	text-align: center;
}
tr:hover{
background-color: #c1c1c1;
}

th{
	background-color: #B0E0E6;
}

#col1{
	width: 10%;
}

#col2{
	width: 20%;
}

#col3{
	width: 20%;
}

a:visited, a:link {
	color:black;
	text-decoration: none;
	
}

small{

color: green;
font-weight: bold;
}

</style>
</head>
<body>
	<%@include file="./menu.jsp" %>
	<div id="main">
	<!-- 이제 jstl을 씁니다 -->
	<h1>공지사항</h1>
<table>
	<tr>
		<th id="col1">번호</th>
		<th id="col3">제목</th>
		<th id="col1">사람</th>
		<th id="col2">쓴날짜</th>
	</tr>
	
	<c:forEach items="${noticeList }" var="i">
	<tr>
		<td>${i.n_no }</tb>
		<td id="tleft">
			<a href ="./noticeDetail?n_no=${i.n_no }">
			${i.n_title }
			</a>
		</tb>
		<td>${i.m_name }</td>
		<td>${i.n_date }</td>
	</tr>
	</c:forEach>
	
</table>
<c:if test="${sessionScope.m_id ne null }">

	<button onclick="location.href='./noticeWrite.jsp'">글쓰기</button>
</c:if>

<%-- <c:choose>
	<c:when test="${sessionScope.m_id ne null }">
	<button onclick="location.href='./noticeWrite.jsp'">글쓰기</button>
	</c:when>
	<c:when test="">
	
	</c:when>
	<c:otherwise>
		<button>공지 작성</button>
	</c:otherwise>
</c:choose> --%>

</div>
</body>
</html>