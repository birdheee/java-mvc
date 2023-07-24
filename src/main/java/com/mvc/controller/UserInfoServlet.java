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

import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoRepository uiRepo = new UserInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		
		if("list".equals(uri)) {
			List<Map<String, String>> userInfoList = uiRepo.selectUserInfoList();
			request.setAttribute("userInfoList", userInfoList);
			path += "user-info/list.jsp";
		}else if("view".equals(uri)){
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
			path += "user-info/view.jsp";
		}else if("insert".equals(uri)) {
			path += "user-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "user-info/update.jsp";
		}else if("delete".equals(uri)) {
			path += "user-info/delete.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "회원등록 실패"); // 실패를 먼저 가정
			request.setAttribute("url", "/user-info/insert");
			if(result==1) { // 1이면 무조건 성공임
				request.setAttribute("msg", "회원등록 완료");
				request.setAttribute("url", "/user-info/list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
