package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.cssyxt.sjk.ylh.dbc.lj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class �޸�jm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					�޸�jm frame = new �޸�jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * �޸Ľ��棬����Ʒ�����޸�
	 */
	public �޸�jm() {
		setTitle("\u4FEE\u6539\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u6240\u9700\u4FEE\u6539\u7684\u5546\u54C1\u4FE1\u606F");
		lblNewLabel.setBounds(37, 10, 240, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(10, 41, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane xgzl = new JTextPane();
		xgzl.setBounds(58, 35, 157, 21);
		contentPane.add(xgzl);
		
		JLabel lblNewLabel_2 = new JLabel("��Ʒ��");
		lblNewLabel_2.setBounds(10, 77, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextPane xgspm = new JTextPane();
		xgspm.setBounds(58, 71, 157, 21);
		contentPane.add(xgspm);
		
		JLabel lblNewLabel_3 = new JLabel("����");
		lblNewLabel_3.setBounds(10, 119, 44, 15);
		contentPane.add(lblNewLabel_3);
		
		JTextPane xgsl = new JTextPane();
		xgsl.setBounds(58, 113, 157, 21);
		contentPane.add(xgsl);
		
		JLabel lblNewLabel_4 = new JLabel("�۸�");
		lblNewLabel_4.setBounds(10, 158, 44, 15);
		contentPane.add(lblNewLabel_4);
		
		JTextPane xgjg = new JTextPane();
		xgjg.setBounds(58, 152, 157, 21);
		contentPane.add(xgjg);
		
		
		JButton btnNewButton = new JButton("�ύ�޸�");
		btnNewButton.setIcon(new ImageIcon(�޸�jm.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�ύ�޸ĺ��������", "",    JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
					//JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "�޸ĳɹ�", JOptionPane.NO_OPTION);
				    
					lj t=new lj();
					String a1="update ��Ʒadd set zl=?,sl=?,money=? where name=?";//ʹ��ռλ������sqlʶ��Integer.parseInt(sl), Float.parseFloat(money));
					try{
					Connection conn=t.getConnection();//��ȡ���ݿ��
					PreparedStatement s = conn.prepareStatement(a1);
					//int changed=s.executeUpdate();
					s.setString(1, xgzl.getText());
					int oo=Integer.parseInt(xgsl.getText());
					s.setInt(2, oo);
					float uu=Float.parseFloat(xgjg.getText());
						s.setFloat(3,uu);
						s.setString(4,xgspm.getText());
						s.executeUpdate();
						
				        if(s.executeUpdate()==0) {JOptionPane.showMessageDialog(null, "�޸���Ʒ������������");}
				        else { JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "�޸ĳɹ�", JOptionPane.NO_OPTION);}
				        s.close();	
				        conn.close();
				        
				       
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "�޸���Ʒ������������");
					}
					
					
				  } else {
				    JOptionPane.showMessageDialog(null, "�����²�������");
				  }
			}
		});
		btnNewButton.setBounds(81, 200, 115, 23);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/apic29974.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}
