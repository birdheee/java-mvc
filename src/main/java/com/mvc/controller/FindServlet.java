package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int rNum;
	private int cnt = 0; // 다시 초기화되어서는 안됨. 멤버변수로 지정해야 함
	
	public FindServlet(){
		Random ra = new Random();
		rNum = ra.nextInt(100)+1;
		
		// 콘솔창에 출력
		System.out.println(rNum);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		
		if("find".equals(uri)) {
			path += "find/find.jsp";
		}else if("check".equals(uri)) {
			int num = Integer.parseInt(request.getParameter("num"));
			String msg = "";
			// 몇번만에 맞췄는지 출력
			if(rNum != num) {
				cnt++;
				msg = "틀렸다.";
			}else {
				msg = "맞췄다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("cnt", cnt);
			path += "find/result.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
