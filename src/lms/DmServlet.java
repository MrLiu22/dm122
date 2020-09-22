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

@WebServlet(urlPatterns="/DmServlet")
public class DmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		//接受提交点名信息
		System.out.print("a");

		request.setCharacterEncoding("utf-8");
		
		//提交表单中的学号文本框内容
		String xh = request.getParameter("xh");

		String xm = request.getParameter("xm");

		String zc = request.getParameter("zc");

		String xq = request.getParameter("xq");

		String ip = request.getRemoteAddr();

		String zh = request.getParameter("zh");

		//调用相关处理方法

		try {
			//点名数据写入数据库
			DmService.addDm(xh, xm, Integer.parseInt(zc), Integer.parseInt(xq), Integer.parseInt(zh), ip, new Date());
			
			
			
			//请求
			List<Dm> dmList = DmService.getDmByXm(xm);
			//转发
			request.setAttribute("dmList", dmList);
			request.setAttribute("msg", "ojbk");
			//储存
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");
			
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("数据库操作错误");
			e.printStackTrace();
			
			//转回登录页面
			request.setAttribute("msg", "八嘎！");
			
			RequestDispatcher rd = request.getRequestDispatcher("dm.jsp");
			
			rd.forward(request, response);
			
		}
		//反馈结果，转发


			}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
