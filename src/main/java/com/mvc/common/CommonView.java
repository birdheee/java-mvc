package com.mvc.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUFFIX = ".jsp";
	private static final String MESSAGE_PATH = "/WEB-INF/views/common/msg.jsp";
	
	public static String getPath(HttpServletRequest req) {
		return PREFIX + req.getRequestURI() + SUFFIX;
	}
	
	public static String getCmd(HttpServletRequest req) {
		String cmd = req.getRequestURI();
		int idx = cmd.lastIndexOf("/")+1;
		return cmd.substring(idx);
	}
	
	public static void forward(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = getPath(req);
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, res);
	}
	
	public static void goMessagePage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(MESSAGE_PATH);
		rd.forward(req, res);
	}
}
