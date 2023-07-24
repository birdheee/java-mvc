package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	// static은 main 메소드 이전에 실행됨 !
	// main 메소드 실행 전 무언가를 기억하고 싶다면 static 사용함
	private static final String DRIVER_NAME="org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/kd";
	private static final String ROOT = "root";
	private static final String PWD = "kd1824java";
	
	// 반드시 한번 해야 하니까
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			return DriverManager.getConnection(URL, ROOT, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println(con);
	}
}