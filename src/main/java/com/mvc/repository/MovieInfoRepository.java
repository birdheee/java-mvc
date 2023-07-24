package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class MovieInfoRepository {
	
	public List<Map<String, String>> selectMovieInfoList(){
		List<Map<String, String>> movieInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				movieInfoList.add(movieInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieInfoList;
	}
	
	public Map<String, String> selectMovieInfo(String miNum){
		Map<String, String> movieInfo = new HashMap<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 AND MI_NUM=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, miNum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miContent", rs.getString("MI_CONTENT"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				return movieInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieInfo;
	}
}