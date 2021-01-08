package cn.cssyxt.sjk.ylh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.cssyxt.stljm.ylh.vo.cssyxt;
/**
 * 连接数据库，并判断里面是否有该信息
 * @author Administrator
 *
 */

public class sjk {
	cssyxt b;
	public void setcssyxt(cssyxt b) {
		this.b=b;
	}
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//定义SQLServer数据库连接地址
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=sjk1";
	private static final String DBUSER="sa"; //SQLServer数据库连接用户名
	private static final String PASSWORD="123456"; //SQLServer数据库连接密码
	private Connection conn=null; //保存连接对象
	public boolean sjk(cssyxt b) throws SQLException,ClassNotFoundException{
		String sql="select * from a1 where zh=? and mm=?";
		Class.forName(DBRIVER);
		Connection conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,cssyxt.getZh());
		ps.setString(2,cssyxt.getMm());
		ResultSet rs = ps.executeQuery();
		int ans=0;
		if(rs.next()) {
        	ans = 1;
        }  
        rs.close();
        ps.close();
        conn.close();
        if(ans == 1) {
        	return true;
        }
        else return false;
	}
	/**
	 * 判断数据库是否有该数据
	 * @return
	 */
	public int JudgeAdmin() {
		
	    try {
	        if(sjk(this.b)) {
	        	System.out.println("登录成功");
	        	return 1;
	        }else {
	            return 0;
	        }
	    }catch(Exception e) {
	        //e.printStackTrace();
	    	//System.out.println("!!!!!!!!!");
	    }
	return 0;
	
}	
	//public sjk() {//构造方法连接数据库
		//try {
			//Class.forName(DBRIVER);
			//this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		//} catch (Exception e) {e.printStackTrace();}
	//}
	/**
	 * 返回数据库连接对象
	 * @return
	 */
	public Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	/**
	 * 关闭数据连接
	 */
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
