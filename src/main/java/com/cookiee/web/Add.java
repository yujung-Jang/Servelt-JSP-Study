package com.cookiee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8"); �Ѿ� ���� ���� �����̹Ƿ� �ǹ̰� ����
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		int x = 0, y = 0, sum = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_); // html���� x, y ������ �����Ƿ� null�� ��� X
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		sum = x + y;
		
		response.getWriter().print(sum);
	}
}