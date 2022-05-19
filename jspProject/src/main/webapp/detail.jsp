<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<script type="text/javascript">
function like(){
	var b_no = ${detail.b_no };
	alert("좋아요를 눌렀습니다");
}

function cup(num){
   var b_no = ${detail.b_no};
   if(confirm("해당 글을 수정하시겠습니까?"))
   location.href="./cup?b_no=" + b_no + "&c_no=" + num;
}
function cdel(num){
	var b_no = ${detail.b_no};
	if(confirm("해당 글을 삭제하시겠습니까?"))
   //location.href="cdel?c_no="+num;
	   location.href="./cdel?b_no=" + b_no + "&c_no=" + num;
}

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="./css/menu.css" rel="stylesheet">
<link href="./css/comment.css" rel="stylesheet">
<style type="text/css">
#main{
   margin: 0 auto;
   width: 800px;
   height: 100%;
}
table {
   width: 100%;
   min-height: 300px;
   border-collapse: collapse;
}
th{
   width: 100px;
   background-color: #c1c1c1;
}
tr{
   min-height:50px;
   border-bottom: 1px red solid;
}
</style>
<c:if test="${detail.m_id eq sessionScope.m_id}">
<script type="text/javascript">
$(document).ready(function(){
   var b_no = ${detail.b_no };
   $("#up").click(function(){
      if(confirm("해당 글을 수정하시겠습니까?")){
         location.replace("./update?b_no="+b_no);
      }
   });
   
   $("#del").click(function(){
      if(confirm("해당 글을 삭제하시겠습니까?")){
         var b_no2 = $("#b_no").text();
         //alert(b_no2 + "번글을 삭제합니다.");
         location.replace("./delete?b_no="+b_no2);
      }
   });
});

</script>
</c:if>
</head>
<body>
   <%@include file="./menu.jsp"%>
   <div id="main">
      <h1>글 상세 보기</h1>
      
      <table>
         <tr>
            <th>번 호</th>
            <td>
               <div id="b_no">${detail.b_no }</div>
               <c:if test="${detail.m_id eq sessionScope.m_id}">
                  <img id="up" alt="" src="./img/update.png" title="수정">
                  <img id="del" alt="" src="./img/del.png" title="삭제">
               </c:if>
            </td>
         </tr>
         <tr>
            <th>제 목</th>
            <td>${detail.b_title }</td>
         </tr>
         <tr>
            <th>글쓴이</th>
            <td>${detail.m_name } / ${detail.m_id }</td>
         </tr>
         <tr>
            <th>조회수</th>
            <td>${detail.b_count }</td>
         </tr>
         <tr>
            <th>좋아요수</th>
            <td>${detail.b_like }</td>
            <td><img alt="좋아요수" src="./img/like.png" title="좋아요수" width="25px;" onclick="like()">
         </tr>
         <tr>
            <th>날 짜</th>
            <td>${detail.b_date }</td>
         </tr>
         <tr>
            <th>내용</th>
            <td>${detail.b_content }</td>
         </tr>
      </table>
   <br>
   
    <c:if test="${sessionScope.m_id ne null }">
	   <div id="comment">
	      <form action="./commentWrite" method="post">
	      <textarea name="content"></textarea>
	      <button type="submit">댓글쓰기</button>
	      <input type="hidden" name="b_no" value="${detail.b_no}">
	      </form>
	   </div>
   </c:if>
   
   <button onclick="location.href='./board'">게시판으로</button>
   </div>
   <br>
      <c:forEach items="${commList }" var="c">
      <div id="comment_row">
      <div id="comment_head">
         <div id="comment_id">
         <input type="hidden" id="c_no" name="c_no" value="${c.c_no }">
            ${c.c_no } / ${c.m_no } / ${c.m_id } / ${c.m_name }
            <c:if test="${sessionScope.m_id eq c.m_id }">
	            <img id="cup" alt="" src="./img/edit.png" title="수정" onclick="cup(${c.c_no})" height=20px;>
	            <img id="cdel" alt="" src="./img/delete.png" title="삭제" onclick="cdel(${c.c_no})" height=20px;>
            </c:if>
            </div>
         <div id="comment_date">${c.c_date }</div>
         </div>
         <div id="comment_body">${c.c_content }</div>
      </div>
      </c:forEach>
      <br>
   
</body>
</html>
