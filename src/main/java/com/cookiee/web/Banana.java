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
		
		String cnt_ = request.getParameter("cnt"); // �ӽ� ������ ���� �޾Ƽ� �˻��Ѵ�
		
		int cnt = 100; // �⺻�� 100
		if(cnt_ != null && !cnt_.equals("")) // �ӽ� ������ null�� �ƴϰų� ������ �ƴ϶��
			cnt = Integer.parseInt(cnt_); // �ӽ� ���� ���� cnt�� ����
		
		for(int i=0; i<cnt; i++)
			out.println((i+1) + ": �ȳ� Servlet!!<br >");
	}
}