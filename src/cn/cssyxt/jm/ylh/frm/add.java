package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.cssyxt.pdff.ylh.dao.addff;
import cn.cssyxt.pdff.ylh.dao.pdadd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * �����Ʒ���棬����Ʒ������ӣ������ظ��������������
	 */
	public add() {
		setTitle("\u6DFB\u52A0\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����");
		lblNewLabel.setBounds(10, 23, 43, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane ����zl = new JTextPane();
		����zl.setBounds(67, 17, 117, 21);
		contentPane.add(����zl);
		
		JLabel lblNewLabel_1 = new JLabel("��Ʒ����");
		lblNewLabel_1.setBounds(10, 63, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane ����name = new JTextPane();
		����name.setBounds(67, 57, 117, 21);
		contentPane.add(����name);
		
		JLabel lblNewLabel_2 = new JLabel("��Ʒ����");
		lblNewLabel_2.setBounds(10, 100, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextPane ����sl = new JTextPane();
		����sl.setBounds(67, 94, 117, 21);
		contentPane.add(����sl);
		
		JLabel lblNewLabel_3 = new JLabel("����");
		lblNewLabel_3.setBounds(10, 136, 50, 15);
		contentPane.add(lblNewLabel_3);
		
		JTextPane ����money = new JTextPane();
		����money.setBounds(67, 130, 117, 21);
		contentPane.add(����money);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zl=����zl.getText();
				String name=����name.getText();
				String sl=����sl.getText();//Integer.parseInt()
				String money=����money.getText();//Float.parseFloat()
				pdadd a=new pdadd();
				a.pdadd(zl, name, sl, money);
				dispose();
				����jm r=new ����jm();
				r.show();
			}
		});
		btnNewButton.setBounds(36, 172, 97, 23);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/336.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}
