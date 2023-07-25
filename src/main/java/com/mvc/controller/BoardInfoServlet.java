package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.CommonView;
import com.mvc.repository.BoardInfoRepository;

public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoRepository biRepo = new BoardInfoRepository();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("list".equals(uri)) {
			List<Map<String, String>> boardInfoList = biRepo.selectBoardInfoList();
			request.setAttribute("boardInfoList", boardInfoList);
		}else if("view".equals(uri)) {
			String biNum = request.getParameter("biNum");
			Map<String, String> boardInfo = biRepo.selectBoardInfo(biNum);
			request.setAttribute("boardInfo", boardInfo);
		}else if("update".equals(uri)) {
		}
		CommonView.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("biTitle", request.getParameter("biTitle"));
			param.put("biWriter", request.getParameter("biWriter"));
			param.put("biContent", request.getParameter("biContent"));
			int result = biRepo.insertBoardInfo(param);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/board-info/insert");
			if(result==1) {
				request.setAttribute("msg", "등록 완료");
				request.setAttribute("url", "/board-info/list");
			}
		}
		CommonView.forward(request, response);
	}
}
