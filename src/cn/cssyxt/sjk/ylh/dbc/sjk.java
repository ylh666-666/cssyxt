package cn.cssyxt.sjk.ylh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.cssyxt.stljm.ylh.vo.cssyxt;
/**
 * �������ݿ⣬���ж������Ƿ��и���Ϣ
 * @author Administrator
 *
 */

public class sjk {
	cssyxt b;
	public void setcssyxt(cssyxt b) {
		this.b=b;
	}
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//����SQLServer���ݿ����ӵ�ַ
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=sjk1";
	private static final String DBUSER="sa"; //SQLServer���ݿ������û���
	private static final String PASSWORD="123456"; //SQLServer���ݿ���������
	private Connection conn=null; //�������Ӷ���
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
	 * �ж����ݿ��Ƿ��и�����
	 * @return
	 */
	public int JudgeAdmin() {
		
	    try {
	        if(sjk(this.b)) {
	        	System.out.println("��¼�ɹ�");
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
	//public sjk() {//���췽���������ݿ�
		//try {
			//Class.forName(DBRIVER);
			//this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		//} catch (Exception e) {e.printStackTrace();}
	//}
	/**
	 * �������ݿ����Ӷ���
	 * @return
	 */
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	/**
	 * �ر���������
	 */
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
