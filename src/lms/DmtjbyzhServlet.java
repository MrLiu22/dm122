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


@WebServlet(urlPatterns="/Zhtj")
public class DmtjbyzhServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		//Ω” ’
		String zc = request.getParameter("zc");
		String xq = request.getParameter("xq");
		
		try {
			
			List<Dmtjbyzh> dmList = DmService.getDmTjbyzh(Integer.parseInt(zc), Integer.parseInt(xq));
			
			request.setAttribute("ZhtjList", dmList);
			
			RequestDispatcher rd = request.getRequestDispatcher("zhtjlist.jsp");
			
			rd.forward(request, response);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	

}
