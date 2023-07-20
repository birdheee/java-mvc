package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;

public class classInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo = new ClassInfoRepository();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/class-info/";
		if("list".equals(uri)) {
			path += "class-info-list.jsp";
			List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
			request.setAttribute("classInfoList", classInfoList);
		}else if("view".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
			path += "class-info-view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
