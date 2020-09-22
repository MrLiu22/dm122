package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns="/ChangeState")
public class StateChangeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
        String username=(String)session.getAttribute("user");
        if("admin".equals(username)){
        	
    		
    		
    			session.setAttribute("user", "admin");  //在session中放入数据--key、value
    			request.setAttribute("msg", "成功登录!!");
    			//转发到dm.jsp
                RequestDispatcher rd = request.getRequestDispatcher("dm.jsp");
    			
    			rd.forward(request, response);
        }
      
		

		

	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
