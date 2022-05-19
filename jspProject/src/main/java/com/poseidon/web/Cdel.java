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

@WebServlet("/cdel")
public class Cdel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cdel() {
		super();

	}
//사용자 로그인 됬는지? bno cno 넘어왔는지 변환, 확인  - dao 호출해서 sql(update)

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("m_id") != null) {
			if (request.getParameter("c_no") != null && request.getParameter("b_no") != null
					&& Util.str2Int(request.getParameter("c_no"))&& Util.str2Int(request.getParameter("b_no"))) {
				CommentDTO dto = new CommentDTO();
				dto.setB_no(Integer.parseInt(request.getParameter("b_no")));
				dto.setC_no(Integer.parseInt(request.getParameter("c_no")));
				dto.setM_id((String)session.getAttribute("m_id"));
				
				CommentDAO dao = new CommentDAO();
				dao.cdel(dto);
				response.sendRedirect("./detail?b_no="+Integer.parseInt(request.getParameter("b_no")));
			} else {
				response.sendRedirect("./board");
			}
		} else {	//로그인X
			response.sendRedirect("./index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
