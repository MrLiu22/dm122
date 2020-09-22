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
		//�����ύ������Ϣ
		System.out.print("a");

		request.setCharacterEncoding("utf-8");
		
		//�ύ���е�ѧ���ı�������
		String xh = request.getParameter("xh");

		String xm = request.getParameter("xm");

		String zc = request.getParameter("zc");

		String xq = request.getParameter("xq");

		String ip = request.getRemoteAddr();

		String zh = request.getParameter("zh");

		//������ش�����

		try {
			//��������д�����ݿ�
			DmService.addDm(xh, xm, Integer.parseInt(zc), Integer.parseInt(xq), Integer.parseInt(zh), ip, new Date());
			
			
			
			//����
			List<Dm> dmList = DmService.getDmByXm(xm);
			//ת��
			request.setAttribute("dmList", dmList);
			request.setAttribute("msg", "ojbk");
			//����
			RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");
			
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("���ݿ��������");
			e.printStackTrace();
			
			//ת�ص�¼ҳ��
			request.setAttribute("msg", "�˸£�");
			
			RequestDispatcher rd = request.getRequestDispatcher("dm.jsp");
			
			rd.forward(request, response);
			
		}
		//���������ת��


			}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
