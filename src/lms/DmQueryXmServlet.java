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


@WebServlet(urlPatterns="/DmQueryXm")
public class DmQueryXmServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		try {
			List<Dm> dmList = DmService.getALLDM();
			
			for(Dm dm:dmList){
				System.out.println(dm.getId() + "  " + dm.getXh()+ "  " + dm.getXm()+ "  ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.print("yeah!");
			e.printStackTrace();
		}
		**/
		request.setCharacterEncoding("utf-8");
		
		String key = request.getParameter("key");
		
		try {
			//ÇëÇó
			List<Dm> dmList = DmService.getDmByXm(key);
			//×ª·¢
			request.setAttribute("dmList", dmList);
			//´¢´æ
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");
			
			rd.forward(request, response);
			
			for(Dm dm:dmList){
				System.out.println(dm.getId() + "  " + dm.getXh()+ "  " + dm.getXm()+ "  ");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	

}
