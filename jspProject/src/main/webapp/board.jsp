<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
background-color:#8F93C0 ;
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
	color:yellow;
	text-decoration: none;
	
}

small{

color: black;
font-weight: bold;
}

</style>
</head>
<body>
	<%@include file="./menu.jsp" %>
	<div id="main">
	<!-- 이제 jstl을 씁니다 -->
	<h1>게시판 만들기</h1>
<table>
	<tr>
		<th id="col1">번호</th>
		<th id="col3">제목</th>
		<th id="col1">사람</th>
		<th id="col2">쓴날짜</th>
		<th id="col1">읽음</th>
		<th id="col1">좋아요</th>
	</tr>
	
	<c:forEach items="${list }" var="i">
	<tr>
		<td>${i.b_no }</tb>
		<td id="tleft">
			<a href ="./detail?b_no=${i.b_no }">
			${i.b_title } <c:if test="${i.commentcount ne 0 }"> <small> ${i.commentcount }</small> </c:if>
			</a>
		</tb>
		<td>${i.m_name }</td>
		<td>${i.b_date }</td>
		<td>${i.b_count }</td>
		<td>${i.b_like }</td>
	</tr>
	</c:forEach>
	
</table>
<c:if test="${sessionScope.m_id ne null }">

	<button onclick="location.href='./write'">글쓰기</button>
</c:if>

<c:choose>
	<c:when test="${sessionScope.m_id ne null }">
	<button onclick="location.href='./write'">글쓰기</button>
	</c:when>
	<c:when test="">
	
	</c:when>
	<c:otherwise>
		<button>글을 쓰려면 로그인하세요</button>
	</c:otherwise>
</c:choose>

</div>
</body>
</html>