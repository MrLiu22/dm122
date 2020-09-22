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
		//链接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("加载驱动错误！");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://172.21.2.248:3306/dm2018";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "111111");
		} catch (SQLException e) {
			System.out.print("数据库连接错误！");
			e.printStackTrace();
		}
		return conn;
	}

	public static void addDm(String xh, String xm, int zc, int xq, int zh, String ip, Date sj) throws SQLException 
	{

		Connection conn = getConnect();

		//在数据库表dm中添加一条记录
		String sql = "insert into dm(xh,xm,zc,xq,zh,ip,sj) values(?,?,?,?,?,?,?)";

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();
		//执行SQL语句
		qr.update(conn, sql, xh, xm, zc, xq, zh, ip, sj);
		//关闭连接
		DbUtils.closeQuietly(conn);
	}
	
	//得到点名的总页数
	public static int getDmCount(){
		String sql="select count(*) from dm";
		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		//List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class),(pageno-1)*pagesize,pagesize);

		//DbUtils.closeQuietly(conn);

		return 491;
		
	}

	//获取第一页，每页20个点名数据List 集合接口
	//pageno:第几页,pagesize:每页大小
	public static List<Dm> getDM(int pageno,int pagesize) throws SQLException
	{

		String sql = "select * from dm limit ?,?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class),(pageno-1)*pagesize,pagesize);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//查询所需点名数据 List 集合接口
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

	//按周期查询 List 集合接口
	public static List<Dm> getDmByZc(int zc, int xq) throws SQLException
	{	
		String sql = "select * from dm where zc = ? and xq = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), zc, xq);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//按桌号查询 List 集合接口
	public static List<Dm> getDmByZh(int zh) throws SQLException
	{	
		String sql = "select * from dm where zh = ?";

		Connection conn = DmService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), zh);

		DbUtils.closeQuietly(conn);

		return list;

	}

	//按学号查询 List 集合接口
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

	//修改记录
	public static void updateDmstate(int id, int state) throws SQLException 
	{

		Connection conn = getConnect();


		String sql = "update dm set yx = ? where id = ?";

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		//执行SQL语句
		qr.update(conn, sql, state, id);

		//关闭连接
		DbUtils.closeQuietly(conn);
	}
	

	//按ID查询
	public static List<Dm> getDmById(int id) throws SQLException
	{	
		String sql = "select * from dm where id = ?";

		//获取数据库连接
		Connection conn = DmService.getConnect();

		//实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		//查询结果输出到list
		List<Dm> list = qr.query(conn, sql, new BeanListHandler(Dm.class), id);

		//释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<Dmtj> getDmTj() throws SQLException
	{	
		String sql = "select xh, xm, count(*) as cs from dm where yx = 1 group by xh order by xh";

		//获取数据库连接
		Connection conn = DmService.getConnect();

		//实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		//查询结果输出到list
		List<Dmtj> list = qr.query(conn, sql, new BeanListHandler(Dmtj.class));

		//释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<Dmtjbyzh> getDmTjbyzh(int zc, int xq) throws SQLException
	{	
		String sql = "select zh,count(zh) as rs from dm where zc=? and xq=? and yx=1 group by zh order by zh";

		//获取数据库连接
		Connection conn = DmService.getConnect();

		//实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		//查询结果输出到list
		List<Dmtjbyzh> list = qr.query(conn, sql, new BeanListHandler(Dmtjbyzh.class), zc, xq);

		//释放资源
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
