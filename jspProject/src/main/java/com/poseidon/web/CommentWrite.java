package com.poseidon.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.CommentDAO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;


@WebServlet("/commentWrite")
public class CommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CommentWrite() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("./board");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("m_id")!= null) {
			if(request.getParameter("b_no") != null && Util.str2Int(request.getParameter("b_no"))) {
				CommentDTO dto = new CommentDTO();
	            dto.setB_no(Integer.parseInt(request.getParameter("b_no")));
	            dto.setC_content(request.getParameter("content"));
	            dto.setM_id(session.getAttribute("m_id").toString());
	            dto.setM_name(session.getAttribute("m_name").toString());
	            CommentDAO dao = new CommentDAO();
	            dao.commentWrite(dto);
	            response.sendRedirect("./detail?b_no=" + dto.getB_no());
			}
			
		}
		
	}

}
