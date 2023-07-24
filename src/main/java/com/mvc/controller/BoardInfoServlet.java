package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.BoardInfoRepository;

public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoRepository biRepo = new BoardInfoRepository();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			List<Map<String, String>> boardInfoList = biRepo.selectBoardInfoList();
			request.setAttribute("boardInfoList", boardInfoList);
			path += "board-info/list.jsp";
		}else if("view".equals(uri)) {
			path += "board-info/view.jsp";
		}else if("insert".equals(uri)) {
			path += "board-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "board-info/update.jsp";
		}else if("delete".equals(uri)) {
			path += "board-info/delete.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
