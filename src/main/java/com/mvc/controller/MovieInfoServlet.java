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
import com.mvc.repository.MovieInfoRepository;

public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieInfoRepository miRepo = new MovieInfoRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("list".equals(uri)) {
			List<Map<String, String>> movieInfoList = miRepo.selectMovieInfoList();
			request.setAttribute("movieInfoList", movieInfoList);
		}else if("view".equals(uri)) {
			Map<String, String> movieInfo = miRepo.selectMovieInfo(request.getParameter("miNum"));
			request.setAttribute("movieInfo", movieInfo);
		}else if("update".equals(uri)) {
		}
		CommonView.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);
		if("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("miTitle", request.getParameter("miTitle"));
			param.put("miGenre", request.getParameter("miGenre"));
			param.put("miCredat", request.getParameter("miCredat"));
			param.put("miCnt", request.getParameter("miCnt"));
			param.put("miContent", request.getParameter("miContent"));
			int result = miRepo.insertMovieInfo(param);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/movie-info/insert");
			if(result==1) {
				request.setAttribute("msg", "등록 성공");
				request.setAttribute("url", "/movie-info/list");
			}
		}
		CommonView.forward(request, response);
	}
}
