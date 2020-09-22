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
		///�жϵ�ǰ�Ƿ�Ϊ����״̬
		//��Servlet����"state"��ʾ--  0->�ǵ���״̬    1->����״̬
		request.setCharacterEncoding("utf-8");
		ServletContext sc=this.getServletContext();
		
		Integer state=(Integer) sc.getAttribute("state");	
		if(state==null||state==0){
			request.setAttribute("msg","��ǰû�п��õĵ���!");
			request.setAttribute("DmState", 0);
		}
		else
			request.setAttribute("DmState", 1);
			
		
		System.out.println(state);
		///ת����dm.jsp
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