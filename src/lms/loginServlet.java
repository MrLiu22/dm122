package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/loginServlet")
public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		

		request.setCharacterEncoding("utf-8");
		
		//提交表单中的学号文本框内容
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		if("admin".equals(username)&&"111111".equals(password)){
			                //登录成功
			               //拿到当前用户的session
			HttpSession session=request.getSession();
			session.setAttribute("user", "admin");  //在session中放入数据--key、value
			request.setAttribute("msg", "成功登录!!");
			//转发到dm.jsp
            RequestDispatcher rd = request.getRequestDispatcher("dm.jsp");
			
			rd.forward(request, response);
			
		}
		else{
			request.setAttribute("msg", "你的用户名或密码输入错误!!");
		}


			}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
