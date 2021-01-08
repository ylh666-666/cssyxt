package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.cssyxt.sjk.ylh.dbc.lj;
/**
 * 商品结算后将销售信息存入统计table
 * @author Administrator
 *
 */
public class 统计add {
public static void addtj(String zl1,String name1,int sl1,float money1) {
	int m=1;
	lj dbcs=new lj();//使用1中定义的连接数据库的类
	String sql="insert into 统计table(zl,name,sl,money) values(?,?,?,?)";//使用占位符定义插入语句
	try(Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
		pstmt.setString(1, zl1);//定义第1个占位符的内容
		pstmt.setString(2, name1);//定义第2个占位符的内容
		pstmt.setInt(3, sl1);
		pstmt.setFloat(4, money1);//定义第3个占位符的内容
		pstmt.executeUpdate();//执行插入语句


	}catch(SQLException e) {//若存在该商品，则添加其数量
		//String a1="update 商品add set sl=sl+sl1 where name=name1";
		//Connection conn=dbcs.getConnection();//获取数据库接
		//PreparedStatement pstmt=conn.prepareStatement(sql);
		//System.out.println(name1);
		lj t=new lj();
		String a1="update 统计table set sl=sl+? where name=?";//使用占位符便于sql识别
		try{
		Connection conn=t.getConnection();//获取数据库接
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
