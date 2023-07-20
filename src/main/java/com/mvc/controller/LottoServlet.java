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

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList<>();
	Random ra = new Random();
	
	// 생성자
	public LottoServlet() {
		// 랜덤 값 생성
		while(lotto.size()<6) {
			int rNum = ra.nextInt(45)+1;
			String strNum = Integer.toString(rNum);
			if(lotto.indexOf(strNum) == -1) {
				lotto.add(strNum);
			}
		}
		// 콘솔창에 출력
		for(int i=0; i<lotto.size(); i++) {
			System.out.println(lotto.get(i));
		}
	}
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";
		}else if("comp".equals(uri)) {
			String[] nums = request.getParameterValues("num"); // 배열로 받음
			// 몇개 맞췄는지 세기
			int cnt = 0;
			for(int i=0; i<lotto.size(); i++) {
				for(int j=0; j<nums.length; j++) {
					if(lotto.get(i).equals(nums[j])) {
						cnt++;
					}
				}
			}
			request.setAttribute("cnt", cnt);
			path += "lotto/result.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
