package com.cookiee.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0)
			result = "홀수";
		else
		 	result = "짝수";
		
		 // result로 담고 result로 사용할 수 있도록 한다
		request.setAttribute("result", result);
		
		//redirect 현재 작업 내용과 상관없이 새로운 요청 가능
		//forward 현재 작업 내용을 이어갈 수 있도록 공유
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}
