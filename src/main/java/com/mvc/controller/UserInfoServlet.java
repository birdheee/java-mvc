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
import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoRepository uiRepo = new UserInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("list".equals(uri)) {
			List<Map<String, String>> userInfoList = uiRepo.selectUserInfoList();
			request.setAttribute("userInfoList", userInfoList);
		}else if("view".equals(uri)){
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("update".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}
		CommonView.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		String uri = CommonView.getCmd(request);
		if("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "회원등록 실패"); // 실패를 먼저 가정
			request.setAttribute("url", "/user-info/insert");
			if(result==1) { // 1이면 무조건 성공임
				request.setAttribute("msg", "회원등록 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}else if("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiNum", request.getParameter("uiNum"));
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.updateUserInfo(param);
			request.setAttribute("msg", "회원정보 수정 실패"); // 실패를 먼저 가정
			request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			if(result==1) {
				request.setAttribute("msg", "회원정보 수정 성공");
				request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			}
		}else if("delete".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			int result = uiRepo.deleteUserInfo(uiNum);
			request.setAttribute("msg", "회원 삭제 실패");
			request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
			if(result==1) {
				request.setAttribute("msg", "회원 삭제 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}
		CommonView.goMessagePage(request, response);
	}

}
