package lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/DmInputServlet",name="DmInputServlet")
public class DmInputServlet extends HttpServlet {

	public DmInputServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///判断当前是否为点名状态
		//在Servlet中用"state"表示--  0->非点名状态    1->点名状态
		request.setCharacterEncoding("utf-8");
		ServletContext sc=this.getServletContext();
		
		Integer state=(Integer) sc.getAttribute("state");	
		if(state==null||state==0){
			request.setAttribute("msg","当前没有可用的点名!");
			request.setAttribute("DmState", 0);
		}
		else
			request.setAttribute("DmState", 1);
			
		
		System.out.println(state);
		///转发到dm.jsp
		RequestDispatcher rd = request.getRequestDispatcher("dm.jsp");
		
		rd.forward(request, response);

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}