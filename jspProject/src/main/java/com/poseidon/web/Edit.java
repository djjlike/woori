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
import com.poseidon.util.Util;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// b_no가 오냐? m_id있어?
		if (request.getParameter("b_no") != null) {
			if (Util.str2Int(request.getParameter("b_no"))) {
				HttpSession session = request.getSession();
				if (session.getAttribute("m_id") != null) {
					int b_no = Integer.parseInt(request.getParameter("b_no"));
					//bno있고 숫자이고 mid 있음
					//원래 써있던 글을 가져와야합니다
					
					BoardDAO dao = new BoardDAO();
					BoardDTO dto = dao.detail(b_no);
					//디스패치 이동
					RequestDispatcher rd = request.getRequestDispatcher("./update.jsp");
					request.setAttribute("dto", dto);
					rd.forward(request,response);
					
				} else {
					response.sendRedirect("./index.jsp");//로그인하세요
				}

			} else {
				response.sendRedirect("./board");//숫자가 아닙니다
			}
		} else {
			response.sendRedirect("./board");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		//b_no, b_title, b_content And m_id
		HttpSession session = request.getSession();
		if(session.getAttribute("m_id")!= null) {
			if(request.getParameter("b_no")!=null  && Util.str2Int(request.getParameter("b_no"))) {
				int b_no = Integer.parseInt(request.getParameter("b_no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				BoardDTO dto = new BoardDTO();
				dto.setB_no(b_no);
				dto.setB_title(title);
				dto.setB_content(content);
				dto.setM_id((String) session.getAttribute("m_id"));
				BoardDAO dao = new BoardDAO();
				dao.update(dto);
				
				response.sendRedirect("./detail?b_no="+b_no);
			}else {
				response.sendRedirect("./board");
			} 
		} else {
			response.sendRedirect("./index.jsp");
		} 
			

	}

}
