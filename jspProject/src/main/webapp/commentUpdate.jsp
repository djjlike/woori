<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 </title>
<style type="text/css">

</style>
</head>
<body>
<%@ include file="./menu.jsp" %>
<div id="main">
	<h1>댓글 수정하기</h1>
	<div id="content">
		<form astion="./cup" method="post">
			<textarea name="comment">${dto.c_content }</textarea>
			<input type="hidden" name="c_no" value="${dto.c_no }">
			<input type="hidden" name="b_no" value="${dto.b_no }">
			<button type="submit">댓글 수정</button>
		</form>	
	
	</div>
			<button onclick="location.href='./board'">보드</button>
			<button onclick="location.href='./detail?b_no=${dto.b_no }'">돌아가기</button>
		
</div>


</body>
</html>