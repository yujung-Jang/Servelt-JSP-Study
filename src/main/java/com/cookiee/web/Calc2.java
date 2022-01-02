package com.cookiee.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext application = request.getServletContext();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산
		if(op.equals("=")) {
			int x = (Integer)application.getAttribute("value"); // Object로 값 반환하므로 변환 필요
			int y = v; // 가장 최근에 입력받은 값
			String operator = (String)application.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			response.getWriter().print(result);
		}
		// 값을 저장
		else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}
	}
}