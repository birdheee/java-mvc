package com.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class BoardInfoRepository {
	
	public List<Map<String, String>> selectBoardInfoList(){
		List<Map<String, String>> boardInfoList = new ArrayList<>();
		Connection con = DBCon.getCon();
		String sql = "SELECT * FROM BOARD_INFO WHERE 1=1 ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> boardInfo = new HashMap<>();
				boardInfo.put("biNum", rs.getString("BI_NUM"));
				boardInfo.put("biTitle", rs.getString("BI_TITLE"));
				boardInfo.put("biWriter", rs.getString("BI_WRITER"));
				boardInfo.put("biCredat", rs.getString("BI_CREDAT"));
				boardInfo.put("biCnt", rs.getString("BI_CNT"));
				boardInfoList.add(boardInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardInfoList;
	}
	
	public Map<String, String> selectBoardInfo(String biNum){
		Map<String, String> boardInfo = new HashMap();
		Connection con = DBCon.getCon();
		String sql = "SELECT * FROM BOARD_INFO WHERE 1=1 AND BI_NUM=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, biNum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				boardInfo.put("biNum", rs.getString("BI_NUM"));
				boardInfo.put("biTitle", rs.getString("BI_TITLE"));
				boardInfo.put("biWriter", rs.getString("BI_WRITER"));
				boardInfo.put("biCredat", rs.getString("BI_CREDAT"));
				boardInfo.put("biCnt", rs.getString("BI_CNT"));
				boardInfo.put("biContent", rs.getString("BI_CONTENT"));
				return boardInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertBoardInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO BOARD_INFO(BI_TITLE, BI_WRITER, BI_CONTENT, BI_CREDAT, BI_CNT)";
		sql += " VALUES(?,?,?,NOW(),0)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("biTitle"));
			pstmt.setString(2, param.get("biWriter"));
			pstmt.setString(3, param.get("biContent"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
