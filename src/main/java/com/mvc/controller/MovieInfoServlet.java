package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.MovieInfoRepository;

public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieInfoRepository miRepo = new MovieInfoRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			List<Map<String, String>> movieInfoList = miRepo.selectMovieInfoList();
			request.setAttribute("movieInfoList", movieInfoList);
			path += "movie-info/list.jsp";
		}else if("view".equals(uri)) {
			Map<String, String> movieInfo = miRepo.selectMovieInfo(request.getParameter("miNum"));
			request.setAttribute("movieInfo", movieInfo);
			path += "movie-info/view.jsp";
		}else if("insert".equals(uri)) {
			path += "movie-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "movie-info/update.jsp";
		}else if("delete".equals(uri)) {
			path += "movie-info/delete.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
