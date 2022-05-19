package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dto.BoardDTO;
import com.poseidon.dto.CommentDTO;

import db.DBConnection;

public class CommentDAO {

	public List<CommentDTO> commentlist(int b_no){
		
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM may_commentview WHERE b_no=?";
		try {
			con = DBConnection.dbConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setC_no(rs.getInt("c_no"));
				dto.setB_no(rs.getInt("b_no"));
				dto.setM_no(rs.getInt("m_no"));
				dto.setC_like(rs.getInt("c_like"));
				dto.setC_date(rs.getNString("c_date"));
				dto.setC_content(rs.getNString("c_content"));
				dto.setM_id(rs.getNString("m_id"));
				dto.setM_name(rs.getNString("m_name"));
				list.add(dto);
			}
				
				
				
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return list;
		
	}

	public void commentWrite(CommentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO may_comment (b_no, c_content, m_no)" + "VALUES (?, ?, (SELECT m_no FROM may_member WHERE m_id=?))";
		
		try {
			con = DBConnection.dbConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_no());
			pstmt.setString(2, dto.getC_content());
			pstmt.setString(3, dto.getM_id());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cdel(CommentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE may_comment SET c_del=1 WHERE c_no=? AND m_no = (SELECT m_no FROM may_member WHERE m_id=?)";
		try {
			con = DBConnection.dbConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getC_no());
			pstmt.setString(2, dto.getM_id());
			pstmt.execute();
		} catch (Exception e) {
	
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
	
			}
		}
	}
	
	public CommentDTO CommentDetail(CommentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM may_commentview WHERE c_no=?";
		
		try {
		con = DBConnection.dbConn();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getC_no());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dto.setC_content(rs.getString("c_content"));
			dto.setC_like(rs.getInt("c_like"));
			dto.setC_date(rs.getString("c_date"));
			dto.setM_id(rs.getString("m_id"));
			dto.setM_name(rs.getString("m_name"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public void commentUpdate(CommentDTO dto) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE may_comment SET c_content=? WHERE c_no = ? AND m_no=(SELECT m_no FROM may_member WHERE m_id=?)";
		try {
			con = DBConnection.dbConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getC_content());
			pstmt.setInt(2, dto.getC_no());
			pstmt.setString(3, dto.getM_id());
			
			pstmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
