package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.JoinDAO;
import com.poseidon.dto.JoinDTO;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Join() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("./join.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      
	      String id = request.getParameter("id");
	      String password = request.getParameter("password");
	      String name = request.getParameter("name");
	      int age = Integer.parseInt(request.getParameter("age"));
	      String address = request.getParameter("address");
	      String email = request.getParameter("email");
	      String tel = request.getParameter("tel");
	     
	      JoinDTO dto = new JoinDTO(age, id, password, name, email, address, tel);
	      JoinDAO dao = new JoinDAO();
	      int result = dao.join(dto);
	      PrintWriter pw = response.getWriter();
	      if(result==0) {
	         System.out.println("가입 안 됨");
	         pw.println("<html>");
	         pw.println("<head>");
	         pw.println("<meta charset=\"UTF-8\">");   
	         pw.println("<title>가입불가</title>");
	         pw.println("</head>");
	         pw.println("<body>");
	         pw.println("<<h1>가입에 실패하였습니다</h1>>");
	         pw.println("<<h2>다시 시도해주세요</h2>>");
	         pw.println("<a href='./join.jsp'>가입하러 가기></a>");
	         pw.println("</body>");
	         pw.println("</html>");
	     
	      } else {
	         System.out.println("가입 됨");
	         pw.println("<html>");
	         pw.println("<head>");
	         pw.println("<meta charset=\"UTF-8\">");   
	         pw.println("<title>가입성공</title>");
	         pw.println("</head>");
	         pw.println("<body>");
	         pw.println("<h1>가입에 성공하였습니다.</h1>");
	         pw.println("<a href='./index'>로그인하러가기</a>");
	         pw.println("</body>");
	         pw.println("</html>");
	      }
	   }
}
