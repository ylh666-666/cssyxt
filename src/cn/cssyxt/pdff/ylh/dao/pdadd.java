package cn.cssyxt.pdff.ylh.dao;

import javax.swing.JOptionPane;
/**
 * �����Ʒʱ�ж�������Ϣ�Ƿ����Ҫ�󣬲������Ʒ��Ϣ�����ݿ�
 * @author Administrator
 *
 */
public class pdadd {
public boolean pdadd(String zl,String name,String sl,String money) {
	if(zl.equals("")) {
		JOptionPane.showMessageDialog(null, "���಻��Ϊ��","����Ϊ��",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(name.equals("")) {
		JOptionPane.showMessageDialog(null, "��Ʒ������Ϊ��","��Ʒ��Ϊ��",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(sl.equals("")) {
		JOptionPane.showMessageDialog(null, "��������Ϊ��","����Ϊ��",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(money.equals("")) {
		JOptionPane.showMessageDialog(null, "�۸���Ϊ��","�۸�Ϊ��",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(Integer.parseInt(sl)<0) {
		JOptionPane.showMessageDialog(null, "��������Ϊ����","����Ϊ����",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(Float.parseFloat(money)<0) {
		JOptionPane.showMessageDialog(null, "�۸���Ϊ����","�۸�Ϊ����",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	JOptionPane.showMessageDialog(null,"��ӳɹ�");
	addff c=new addff();
	c.addsp(zl, name, Integer.parseInt(sl), Float.parseFloat(money));
	return true;
}
}
