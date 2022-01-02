package com.cookiee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Banana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt"); // 임시 변수로 값을 받아서 검사한다
		
		int cnt = 100; // 기본값 100
		if(cnt_ != null && !cnt_.equals("")) // 임시 변수가 null이 아니거나 공백이 아니라면
			cnt = Integer.parseInt(cnt_); // 임시 변수 값을 cnt에 저장
		
		for(int i=0; i<cnt; i++)
			out.println((i+1) + ": 안녕 Servlet!!<br >");
	}
}