Servlet Calculator
==================

> 다음 강의의 내용을 포함하고 있습니다. [강의 영상](https://youtube.com/playlist?list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd)   

```
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Banana extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Hello Servlet");
	}
}
```

1. Context
```
<Host name="localhost" appBase=" D:\home ">
	<Context path = "가상경로(실제 존재 X)" docBase="전체경로(서비스하려는 경로)" privileged="true"/>
</Host>
```
2. Annotation - URL Mapping
```
@WebServlet("/hello")
```
3. Print Fomat - Korean Language Print
```
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
```
4. GET Request - Query String, Default Value, User Request
```
String cnt_ = request.getParameter("cnt");
		
int cnt = 100;
if(cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(cnt_);
```
```
<form action="hi">
```
5. POST Request
```
<form action="notion-reg" method="post">
```
6. Servlet Filter
7. Input Data - Array
```
String[] num_ = request.getParameterValues("num");
```
8. Keep State
9. Application Object
```
// 어플리케이션 저장소
ServletContext application = request.getServletContext();

// 어플리케이션에 저장할 값, 키와 값(Map 컬렉션과 유사)
application.setAttribute("value", v);
application.setAttribute("op", op);
```
10. Session Object - User classification of WAS
```
HttpSession session = request.getSession();

session.setAttribute("value", v);
session.setAttribute("op", op);
```
```
void setAttribute(String name, Object value) // 지정된 이름으로 객체를 설정
Object getAttribute(String name) // 지정한 이름의 객체를 반환
void invalidate() // 세션에서 사용되는 객체들을 바로 해제

void setMaxInactiveIntervale(int interval) // 세션 타임아웃을 정수(초)로 설정
boolean isNew() // 세션이 새로 생성되었는지를 확인
Long getCreationTime() // 세션이 시작된 시간을 반환, 1970년 1월 1일을 시작으로 하는 밀리초
long getLastAccessedTime() // 마지막 요청 시간, 1970년 1월 1일을 시작으로 하는 밀리초
```
11. Cookie - path, maxAge Option and Delete
12. redirection - Switch pages from the server
```
response.sendRedirect("calc2.html");
```
13. Dynamic Page
14. GET, POST - Service Functions
15. Calculator Servlet - One Servlet
