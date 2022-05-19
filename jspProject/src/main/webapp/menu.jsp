<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="menu">
      <div id="navi">
         <ul>
            <li><a href="./index.jsp">홈</a></li>
            <li><a href="./main.jsp">메인</a></li>
            <li><a href="./board">보드</a></li>
            <li>Mac</li>
            <li>iPad</li>
            <% if(session.getAttribute("m_name") == null){ %>
               <li><img src="./login.png" onclick="location.href='./index'">로그인</li>
            <%} else { %>
               <li>
                  <a href="./userInfo">
                     <%=session.getAttribute("m_name") %>님 반갑습니다.
                    </a>
               </li>
               <li><img src="./logout.png" onclick="logout()" alt="로딩 실패"></li>
         <%} %>
         </ul>
      </div>
   </div>
   
  <script type="text/javascript">
 function logout(){
	 if( confirm ("로그아웃을 하시겠습니까?")) {
	location.href="./logout";
	 }
 }
   
   
   </script>