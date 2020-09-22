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


@WebServlet(urlPatterns="/DmQuery")
public class DmQueryServlet extends HttpServlet {

	
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
		String pageno=request.getParameter("pageno");
		int pa=Integer.parseInt(pageno);
		try {
			int sum = DmService.getDmCount();
			Page p=new Page(sum,10,pa);
			List<Dm> dmList=DmService.getDM(pa, 20);
			request.setAttribute("dmList", dmList);
			request.setAttribute("page", p);
			
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
