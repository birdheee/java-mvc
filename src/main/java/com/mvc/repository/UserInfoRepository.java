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

public class UserInfoRepository {
	
	public List<Map<String, String>> selectUserInfoList(){
		List<Map<String, String>> userInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM USER_INFO WHERE 1=1 ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> userInfo = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}
	
	public Map<String, String> selectUserInfo(String uiNum){
		Map<String, String> userInfo = new HashMap<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uiNum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertUserInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO USER_INFO(UI_ID, UI_PWD, UI_NAME)";
		sql += " VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("uiId"));
			pstmt.setString(2, param.get("uiPwd"));
			pstmt.setString(3, param.get("uiName"));
			return pstmt.executeUpdate(); // result
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "UPDATE USER_INFO";
		sql += " SET UI_ID=?, UI_PWD=?, UI_NAME=? WHERE UI_NUM=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("uiId"));
			pstmt.setString(2, param.get("uiPwd"));
			pstmt.setString(3, param.get("uiName"));
			pstmt.setString(4, param.get("uiNum"));
			return pstmt.executeUpdate(); // result
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteUserInfo(String uiNum) {
		Connection con = DBCon.getCon();
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uiNum);
			return pstmt.executeUpdate(); // result
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}