package cn.cssyxt.pdff.ylh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.cssyxt.sjk.ylh.dbc.lj;
/**
 * 商品结算后将销售信息及时间存入
 * @author Administrator
 *
 */
public class 时间add {
public static void sj(String zl1,String name1,String sl1,String money1,String sj1){
	lj dbcs=new lj();//使用1中定义的连接数据库的类
	String sql="insert into 时间table(zl,name,sl,money,sj) values(?,?,?,?,?)";//使用占位符定义插入语句
	try(Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
		pstmt.setString(1, zl1);//定义第1个占位符的内容
		pstmt.setString(2, name1);//定义第2个占位符的内容
		pstmt.setString(3, sl1);
		pstmt.setString(4, money1);
		pstmt.setString(5, sj1);
		pstmt.executeUpdate();//执行插入语句


	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
