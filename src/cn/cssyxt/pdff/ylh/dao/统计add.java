package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.cssyxt.sjk.ylh.dbc.lj;
/**
 * ��Ʒ�����������Ϣ����ͳ��table
 * @author Administrator
 *
 */
public class ͳ��add {
public static void addtj(String zl1,String name1,int sl1,float money1) {
	int m=1;
	lj dbcs=new lj();//ʹ��1�ж�����������ݿ����
	String sql="insert into ͳ��table(zl,name,sl,money) values(?,?,?,?)";//ʹ��ռλ������������
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
		pstmt.setString(1, zl1);//�����1��ռλ��������
		pstmt.setString(2, name1);//�����2��ռλ��������
		pstmt.setInt(3, sl1);
		pstmt.setFloat(4, money1);//�����3��ռλ��������
		pstmt.executeUpdate();//ִ�в������


	}catch(SQLException e) {//�����ڸ���Ʒ�������������
		//String a1="update ��Ʒadd set sl=sl+sl1 where name=name1";
		//Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		//PreparedStatement pstmt=conn.prepareStatement(sql);
		//System.out.println(name1);
		lj t=new lj();
		String a1="update ͳ��table set sl=sl+? where name=?";//ʹ��ռλ������sqlʶ��
		try{
		Connection conn=t.getConnection();//��ȡ���ݿ��
		PreparedStatement s = conn.prepareStatement(a1);
			s.setInt(1,sl1);
			s.setString(2,name1);
			s.executeUpdate();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
}
