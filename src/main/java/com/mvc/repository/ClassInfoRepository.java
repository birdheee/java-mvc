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

public class ClassInfoRepository {
	
	public List<Map<String, String>> selectClassInfoList() {
		List<Map<String, String>> classInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
		
	}
	
	public Map<String, String> selectClassInfo(String ciNum){
		Map<String, String> classInfo = new HashMap<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ciNum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				return classInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertClassInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO CLASS_INFO(CI_NAME, CI_DESC)";
		sql += " VALUES(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("ciName"));
			pstmt.setString(2, param.get("ciDesc"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateClassInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "UPDATE CLASS_INFO SET CI_NAME=?, CI_DESC=? WHERE CI_NUM=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("ciName"));
			pstmt.setString(2, param.get("ciDesc"));
			pstmt.setString(3, param.get("ciNum"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteClassInfo(String ciNum) {
		Connection con = DBCon.getCon();
		String sql = "DELETE FROM CLASS_INFO WHERE CI_NUM=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ciNum);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}