package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * ע��ʱ�ж�������Ϣ�Ƿ����Ҫ�󣬲����ע����Ϣ
 * @author Administrator
 *
 */
public class pd {
	String zh;
	String mm;
	String qrmm;
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=sjk1";
	private static final String DBUSER="sa"; //SQLServer���ݿ������û���
	private static final String PASSWORD="123456"; //SQLServer���ݿ���������
	private Connection conn=null; //�������Ӷ���
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
			JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��","�˺�Ϊ��",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(this.mm.equals("")) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��","����Ϊ��",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!this.mm.equals(this.qrmm)) {
			JOptionPane.showMessageDialog(null, "������������벻һ��","���벻һ��",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null,"ע��ɹ�");
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
    		System.out.println("����û�ʧ�ܣ�");
    	}
    	
    }
}
