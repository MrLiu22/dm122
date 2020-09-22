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

@WebServlet(urlPatterns="/DmQueryZh")
public class DmQueryZhServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String zh = request.getParameter("zh");

		try {
			//����
			List<Dm> dmList = DmService.getDmByZh(Integer.parseInt(zh));
			//ת��
			request.setAttribute("dmList", dmList);
			//����
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");

			rd.forward(request, response);

			for(Dm dm:dmList){
				System.out.println(dm.getZh());
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
