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
}