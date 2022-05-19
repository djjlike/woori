<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="./css/menu.css" rel="stylesheet">
</head>
<body>
<%@include file="./menu.jsp" %>
<style>

#main{
margin: 0 auto;
width:800px;
height: 100%;
}

#loginform{
margin: 0 auto;
width:300px;
height: 450px;
background-color:gray;
padding:10px;
}

#loginform input, buttom{
margin: 0;
padding: 0;
background-color: white;
border: 0;
height: 40px;
width: 100%;
}

#loginform input{

margin-bottom: 10px;
}

#loginform input:hover, bottom:hover{

margin-bottom: #ADFF2F;
}






</style>
	<div>
		<div id="loginform">
			<form action="./login" method="post">
				<img src="./dada.png" alt="">
				<input type ="text" name="id" required="required">
				<input type ="password" name="pw" required="required">
				<button>LOGIN</button>
			</form>
			<a href="join.jsp">회원가입</a>
		</div>
	</div>
<% 
String error = request.getParameter("error");
if(error != null){
%>
<script type="text/javascript">
alert("아이디와 비밀번호가 일치하지 않습니다")
</script>
<%} %>


</body>
</html>