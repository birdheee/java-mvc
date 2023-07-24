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

import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo = new ClassInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "class-info/list.jsp";
			List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
			request.setAttribute("classInfoList", classInfoList);
		}else if("view".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
			path += "class-info/view.jsp";
		}else if("insert".equals(uri)) {
			path += "class-info/insert.jsp";
		}else if("update".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
			path += "class-info/update.jsp";
		}else if("delete".equals(uri)) {
			path += "class-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.insertClassInfo(param);
			request.setAttribute("msg", "과목등록 실패");
			request.setAttribute("url", "/class-info/insert");
			if(result==1) {
				request.setAttribute("msg", "과목등록 성공");
				request.setAttribute("url", "/class-info/list");
			}
		}else if("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("ciNum", request.getParameter("ciNum"));
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.updateClassInfo(param);
			request.setAttribute("msg", "과목정보 수정 실패");
			request.setAttribute("url", "/class-info/update?ciNum=" + request.getParameter("ciNum"));
			if(result==1) {
				request.setAttribute("msg", "과목정보 수정 성공");
				request.setAttribute("url", "/class-info/list");
			}
		}else if("delete".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			int result = ciRepo.deleteClassInfo(ciNum);
			request.setAttribute("msg", "과목 삭제 실패");
			request.setAttribute("url", "/class-info/view?ciNum=" + ciNum);
			if(result==1) {
				request.setAttribute("msg", "과목 삭제 성공");
				request.setAttribute("url", "/class-info/list");
			}
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
