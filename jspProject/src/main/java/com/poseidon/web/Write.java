package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;


@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Write() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("m_name")!= null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("./write.jsp");
			rd.forward(request, response);
		
		}else {
			response.sendRedirect("./index.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String re =null;
		if(session.getAttribute("m_name")!= null) {
			if(request.getParameter("title") != null && request.getParameter("content")!= null) {
				
				BoardDTO dto = new BoardDTO();
				dto.setB_content(request.getParameter("content"));
				dto.setB_title(request.getParameter("title"));
				dto.setM_id((String)session.getAttribute("m_id"));
				dto.setM_name((String)session.getAttribute("m_name"));
				BoardDAO dao = new BoardDAO();
				dao.write(dto);
				
				re = "./board";
			} else {
			re = "./board";
			}
		} else {
			re = "./index.jsp";
			
		}
		response.sendRedirect(re);
	}
		
}