<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
<style type="text/css">
#main{
margin: 0 auto;
width:800px;
height: 100%;
}

#noticeWriteform{
margin: 0 auto;
margin-top:100px;
padding: 10px;
width:500px;
height:500px;
background-color:#88F2F5;

}
#noticeWriteform input{
margin: 0;
line-height: 30px; /* 위 아래 중앙 정렬 높이만큼 줌*/
width: 100%;
height: 30px;
margin-bottom: 5px;
box-sizing: border-box;
padding: 5px;
}

#noticeWriteform textarea{

width: 100%;
height: 400px;
margin-bottom: 5px;
padding: 5px;
margin: 0;
box-sizing: border-box;
}


</style>
</head>
<body>
	<!-- menu -->
	<div id="noticeWriteform">
		<form action ="./noticeWrite" method="post" enctype="multipart/form-data">
		<input type="text" name="title" required="required">
		<textarea name="content"></textarea>
		<input type="file" name="file" accept="image/*">
		<button type="submit">공지 등록</button>
		
		</form>
	
	</div>
	

</body>
</html>

