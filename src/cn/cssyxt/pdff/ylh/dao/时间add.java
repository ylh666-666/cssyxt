package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.cssyxt.sjk.ylh.dbc.lj;
/**
 * ��Ʒ�����������Ϣ��ʱ�����
 * @author Administrator
 *
 */
public class ʱ��add {
public static void sj(String zl1,String name1,String sl1,String money1,String sj1){
	lj dbcs=new lj();//ʹ��1�ж�����������ݿ����
	String sql="insert into ʱ��table(zl,name,sl,money,sj) values(?,?,?,?,?)";//ʹ��ռλ������������
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
		pstmt.setString(1, zl1);//�����1��ռλ��������
		pstmt.setString(2, name1);//�����2��ռλ��������
		pstmt.setString(3, sl1);
		pstmt.setString(4, money1);
		pstmt.setString(5, sj1);
		pstmt.executeUpdate();//ִ�в������


	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
