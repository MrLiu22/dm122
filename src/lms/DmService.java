package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DmService {



	public static Connection getConnect()
	{
		//�������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("������������");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://172.21.2.248:3306/dm2018";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "111111");
		} catch (SQLException e) {
			System.out.print("���ݿ����Ӵ���");
			e.printStackTrace();
		}
		return conn;
	}

	public static void addDm(String xh, String xm, int zc, int xq, int zh, String ip, Date sj) throws SQLException 
	{

		Connection conn = getConnect();

		//�����ݿ��dm�����һ����¼
		String sql = "insert into dm(xh,xm,zc,xq,zh,ip,sj) values(?,?,?,?,?,?,?)";

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();
		//ִ��SQL���
		qr.update(conn, sql, xh, xm, zc, xq, zh, ip, sj);
		//�ر�����
		DbUtils.closeQuietly(conn);
	}
	
	//�õ���������ҳ��
	public static int getDmCount(){
		String sql="select count(*) from dm";
		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		//List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class),(pageno-1)*pagesize,pagesize);

		//DbUtils.closeQuietly(conn);

		return 491;
		
	}

	//��ȡ��һҳ��ÿҳ20����������List ���Ͻӿ�
	//pageno:�ڼ�ҳ,pagesize:ÿҳ��С
	public static List<Dm> getDM(int pageno,int pagesize) throws SQLException
	{

		String sql = "select * from dm limit ?,?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class),(pageno-1)*pagesize,pagesize);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//��ѯ����������� List ���Ͻӿ�
	public static List<Dm> getDmByXm(String key) throws SQLException
	{
		key = "%"+key+"%";

		String sql = "select * from dm where xm like ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), key);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//�����ڲ�ѯ List ���Ͻӿ�
	public static List<Dm> getDmByZc(int zc, int xq) throws SQLException
	{	
		String sql = "select * from dm where zc = ? and xq = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), zc, xq);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//�����Ų�ѯ List ���Ͻӿ�
	public static List<Dm> getDmByZh(int zh) throws SQLException
	{	
		String sql = "select * from dm where zh = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), zh);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//��ѧ�Ų�ѯ List ���Ͻӿ�
	public static List<Dm> getDmByXh(String xh) throws SQLException
	{	
		String sql = "select * from dm where xh = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), xh);

		DbUtils.closeQuietly(conn);

		return list;

	}

	public static List<Dm> getDmByIp(String ip) throws SQLException
	{	
		String sql = "select * from dm where ip = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), ip);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//�޸ļ�¼
	public static void updateDmstate(int id, int state) throws SQLException 
	{

		Connection conn = getConnect();


		String sql = "update dm set yx = ? where id = ?";

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		//ִ��SQL���
		qr.update(conn, sql, state, id);

		//�ر�����
		DbUtils.closeQuietly(conn);
	}
	

	//��ID��ѯ
	public static List<Dm> getDmById(int id) throws SQLException
	{	
		String sql = "select * from dm where id = ?";

		//��ȡ���ݿ�����
		Connection conn = DmService.getConnect();

		//ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		//��ѯ��������list
		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), id);

		//�ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<Dmtj> getDmTj() throws SQLException
	{	
		String sql = "select xh, xm, count(*) as cs from dm where yx = 1 group by xh order by xh";

		//��ȡ���ݿ�����
		Connection conn = DmService.getConnect();

		//ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		//��ѯ��������list
		List<Dmtj> list = qr.query(conn, sql, new BeanListHandler(Dmtj.class));

		//�ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<Dmtjbyzh> getDmTjbyzh(int zc, int xq) throws SQLException
	{	
		String sql = "select zh,count(zh) as rs from dm where zc=? and xq=? and yx=1 group by zh order by zh";

		//��ȡ���ݿ�����
		Connection conn = DmService.getConnect();

		//ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		//��ѯ��������list
		List<Dmtjbyzh> list = qr.query(conn, sql, new BeanListHandler(Dmtjbyzh.class), zc, xq);

		//�ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<Dm> getDmByZcZh(int zc, int xq, int zh) throws SQLException
	{	
		String sql = "select * from dm where zc = ? and xq = ? and zh = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), zc, xq, zh);

		DbUtils.closeQuietly(conn);

		return list;

	}

}
