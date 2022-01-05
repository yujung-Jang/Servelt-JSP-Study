package com.cookiee.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// ���
		if(op.equals("=")) {
			int x = 0;
			for(Cookie c : cookies)
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			
			int y = v; // ���� �ֱٿ� �Է¹��� ��
			
			String operator = "";
			for(Cookie c : cookies)
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			response.getWriter().print(result);
		}
		// ���� ����
		else {
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); // ��Ű�� ���ڿ��� ����
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2"); // ��Ű�� ���޵Ǵ� ���(URL)�� ����
			valueCookie.setMaxAge(24*60*60); // �� ����, �������� �ݾƵ� 24�ð� ���� ��Ű�� ������� �ʴ´�
			opCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
		}
	}
}