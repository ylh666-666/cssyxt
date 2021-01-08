package cn.cssyxt.pdff.ylh.dao;

import javax.swing.JOptionPane;
/**
 * 添加商品时判断输入信息是否符合要求，并添加商品信息到数据库
 * @author Administrator
 *
 */
public class pdadd {
public boolean pdadd(String zl,String name,String sl,String money) {
	if(zl.equals("")) {
		JOptionPane.showMessageDialog(null, "种类不能为空","种类为空",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(name.equals("")) {
		JOptionPane.showMessageDialog(null, "商品名不能为空","商品名为空",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(sl.equals("")) {
		JOptionPane.showMessageDialog(null, "数量不能为空","数量为空",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(money.equals("")) {
		JOptionPane.showMessageDialog(null, "价格不能为空","价格为空",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(Integer.parseInt(sl)<0) {
		JOptionPane.showMessageDialog(null, "数量不能为负数","数量为负数",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(Float.parseFloat(money)<0) {
		JOptionPane.showMessageDialog(null, "价格不能为负数","价格为负数",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	JOptionPane.showMessageDialog(null,"添加成功");
	addff c=new addff();
	c.addsp(zl, name, Integer.parseInt(sl), Float.parseFloat(money));
	return true;
}
}
