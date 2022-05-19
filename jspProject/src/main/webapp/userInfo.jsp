<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보보기</title>
<link href="./menu.css" rel="stylesheet">
</head>
<body>
<%@include file="./menu.jsp" %>
<div id="main">
	서버에서 오는 값 : ${userInfo }
	아이디 : ${userInfo.id }<br>
	비밀번호 :  ${userInfo.password }<br>
	이름 :  ${userInfo.name }<br>
	주소 :  ${userInfo.address }<br>
	이메일 :  ${userInfo.email }<br>
	전화번호 :  ${userInfo.tel }<br>
</div>

</body>
</html>