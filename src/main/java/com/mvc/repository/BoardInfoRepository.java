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
}
