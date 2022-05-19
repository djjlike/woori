package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.JoinDAO;
import com.poseidon.dao.LoginDAO;
import com.poseidon.dto.JoinDTO;


@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserInfo() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("m_id")!=null) {
			JoinDTO dto = new JoinDTO((String) session.getAttribute("m_id"));
				
			/*
			 * 1. jsp에서 데이터베이스 접속, sql, 결과담기 등등등 작업을 모두 다 함
			 * 2. DTO 구분, DAO가 데이터베이스 작업을 하고 결과를 넘겨주면 jsp에서 출력
			 * 3. Servlte() DAO,ATO를 불러와서 작업하고 그 결과를 넘겨주는 방법		
			 */
			
			LoginDAO dao = new LoginDAO();
			dto = dao.userInfo(dto);
			
			System.out.println(dto.getAddress());
			System.out.println(dto.getAge());
			System.out.println(dto.getEmail());
			System.out.println(dto.getName());
			System.out.println(dto.getPassword());
			System.out.println(dto.getTel());
			
			response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
			pw.println("<title>"+dto.getId()+"님의 정보</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>"+dto.getId()+"님의 정보보기</h1>");
			pw.println("아이디 :" +dto.getId());
			pw.println("암호 :" +dto.getPassword());
			pw.println("이름 :" +dto.getName());
			pw.println("주소 :" +dto.getAddress());
			pw.println("전화번호 :" +dto.getTel());
			pw.println("나이 :" +dto.getAge());
			pw.println("<hr>");
			pw.println("</body>");
			pw.println("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("./userInfo.jsp");
			
			request.setAttribute("userInfo", dto);
			rd.forward(request, response);
			
		}else {
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

}
