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

@WebServlet(urlPatterns="/DmQueryIp")
public class DmQueryIpServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//接收
		String ip = request.getParameter("ip");

		try {
			//请求
			List<Dm> dmList = DmService.getDmByIp(ip);
			//转发
			request.setAttribute("dmList", dmList);
			//储存
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");

			rd.forward(request, response);

			for(Dm dm:dmList){
				System.out.println(dm.getIp());
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
