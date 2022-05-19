package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.CommentDAO;
import com.poseidon.dto.CommentDTO;


@WebServlet("/cup")
public class Cup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cup() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("b_no"));
		System.out.println(request.getParameter("c_no"));
		System.out.println(session.getAttribute("m_id"));
		if(session.getAttribute("m_id")!=null && request.getParameter("c_no")!=null) {
			
			CommentDTO dto = new CommentDTO();
			dto.setB_no(Integer.parseInt(request.getParameter("b_no")));
			dto.setC_no(Integer.parseInt(request.getParameter("c_no")));
			dto.setM_id((String) session.getAttribute("m_id"));
			
			CommentDAO dao = new CommentDAO();
			dto = dao.CommentDetail(dto);
			
			RequestDispatcher rd = request.getRequestDispatcher("./commentUpdate.jsp");
			request.setAttribute("dto", dto);
			rd.forward(request, response);
		}else {
			//값이 안들어온다면 여기로
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("m_id")!=null && request.getParameter("c_no")!=null &&request.getParameter("comment")!=null ) {
			CommentDTO dto = new CommentDTO();
			dto.setB_no(Integer.parseInt(request.getParameter("b_no")));
			dto.setC_no(Integer.parseInt(request.getParameter("c_no")));
			dto.setM_id((String) session.getAttribute("m_id"));
			dto.setC_content(request.getParameter("comment"));
			CommentDAO dao = new CommentDAO();
			dao.commentUpdate(dto);
		
		}else {
			
		}
		response.sendRedirect("./detail?b_no=" + request.getParameter("b_no"));
		
	}
	
}
