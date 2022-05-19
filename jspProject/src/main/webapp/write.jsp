<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link href="./menu.css" rel="stylesheet">
<style>

#main{
margin: 0 auto;
width:800px;
height: 100%;
}
#main input, #main textarea, #btn{
     border: 0;
     background-color: #c1c1c1;
     margin-bottom: 10px;
     width: 100%;
     padding: 10px;
     box-sizing: border-box;
   }
#main textarea {
	
	height: 500px;
	
}

#main input {
	height: 50px;
	
}

#btn {
	
	height: 50px;
	width: 150px;
	background-color: #c1c1c1;
}

</style>
<script type="text/javascript">
function check(){
	var title = document.getElementById("title");
	//alert(title);
	//alert(title.value);
	//alert(title.value.length);
	if(title.value.length < 5){
		alert("제목은 다섯 글자 이상이어야 합니다");
		title.focus();
		return false;
	}
	
	return true;
	
}
</script>
</head>
<body>
<%@include file="./menu.jsp" %>
	<div id="main">
		<h1>글쓰기</h1>
		<form action="./write" method="post" onsubmit="return check()">
		<input type="text" id="title" name ="title" placeholder="제목을 입력하세요">
		<textarea id="summernote" name="content"></textarea>
		<button id="btn" type="submit">글쓰기</button>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
		  $('#summernote').summernote({
			  height : 400
		  });
		});
	</script>
</body>
</html>