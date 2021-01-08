package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * 注册时判断输入信息是否符合要求，并添加注册信息
 * @author Administrator
 *
 */
public class pd {
	String zh;
	String mm;
	String qrmm;
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=sjk1";
	private static final String DBUSER="sa"; //SQLServer数据库连接用户名
	private static final String PASSWORD="123456"; //SQLServer数据库连接密码
	private Connection conn=null; //保存连接对象
	public void setZh(String zh) {
		this.zh = zh;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public void setQrmm(String qrmm) {
		this.qrmm = qrmm;
	}
	public boolean pd1() throws ClassNotFoundException, SQLException {
		if(this.zh.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空","账号为空",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(this.mm.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空","密码为空",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!this.mm.equals(this.qrmm)) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致","密码不一致",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null,"注册成功");
		addAdmin();
		return true;
	}
	public void addAdmin() throws ClassNotFoundException, SQLException{
    	String sql="insert into a1 (zh,mm) values (?,?)";
    	Class.forName(DBRIVER);
    	try {
	    	Connection conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.zh);
	        ps.setString(2, this.mm);
	       
	        ps.executeUpdate();
	        ps.close();	
	        conn.close();
	        
    	}catch(SQLException ex) {
    		System.out.println("添加用户失败！");
    	}
    	
    }
}
