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

@WebServlet(urlPatterns="/DmQueryZc")
public class DmQueryZcServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String zc = request.getParameter("zc");
		String xq = request.getParameter("xq");

		try {
			//ÇëÇó
			List<Dm> dmList = DmService.getDmByZc(Integer.parseInt(zc), Integer.parseInt(xq));
			//×ª·¢
			request.setAttribute("dmList", dmList);
			//´¢´æ
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");

			rd.forward(request, response);

			for(Dm dm:dmList){
				System.out.println(dm.getZc() + " " + dm.getXq() + " ");
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
