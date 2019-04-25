package web.store.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//配置文件的默认配置!要求你必须给出c3p0-config.xml
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//它是事物专用连接
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
	 //当con不等于null时,说明已经调用了beginTransaction(),表示开启了业务
		if(con != null) return con;
		return dataSource.getConnection();
	}
	
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	/*
	 * 开启事物
	 * 1.获取一个Connection,设置它的setAutoComnit(false)
	 * 2.还要保证dao中使用的连接是我们刚创建的
	 * ------
	 * 1.创建一个Connection,设置为手动提交
	 * 2.把这个Connection给dao用
	 * 3.还要让commitTransaction或者rollbackTransaction
	 * 
	 */
	
	
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();//获取当前线程的专用连接
		if(con != null) throw new SQLException("已经开启了事物,不需要重复开启");
		/*
		 * 1.给con赋值！
		 * 2.给con设置为手动提交
		 */
		con = getConnection();//给con赋值,表示事物已经开始了
		con.setAutoCommit(false);
		
		tl.set(con);//把当前线程连接保存起来
	}
	
	/*
	 * 提交事物
	 * 1.获取 beginTransaction提供的Connection,然后调用commit方法
	 * 
	 */
	
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();//获取当前
		if(con == null) throw new SQLException("还没开启事物,不能提交");
		//直接使用con.commit()
		con.commit();
		con.close();
	    //把它设置为null,表示事物已经结束!下次再去调用getConnection()返回的就不是con了
		tl.remove();//从t1中移除连接
	}
	/*
	 * 提交事物
	 * 获取 beginTransaction提供的Connection,然后调用rollback方法
	 */
	
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if(con == null) throw new SQLException("还没开启事物,不能回滚");
		
		con.rollback();
		con.close();
		tl.remove();
	}
	
	
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();
		/*
		 * 判断它是不是事物专用,如果是,就不关闭!
		 * 如果不是事务专用,就要关闭
		 */
		//如果con=null,说明现在没有事物,那么connection一定不是事务专用!
		if(con == null) connection.close();
	//如果con!=null,说明有事物,那么需要判断连接是否与con相等,若不等,说明参数连接不是事物专用连接
		
		if(con != connection) connection.close();
		
	}
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
