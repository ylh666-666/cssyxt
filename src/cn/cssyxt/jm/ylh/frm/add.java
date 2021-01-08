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
	 * 添加商品界面，对商品进行添加，如有重复，则添加其数量
	 */
	public add() {
		setTitle("\u6DFB\u52A0\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("种类");
		lblNewLabel.setBounds(10, 23, 43, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane 输入zl = new JTextPane();
		输入zl.setBounds(67, 17, 117, 21);
		contentPane.add(输入zl);
		
		JLabel lblNewLabel_1 = new JLabel("商品名称");
		lblNewLabel_1.setBounds(10, 63, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane 输入name = new JTextPane();
		输入name.setBounds(67, 57, 117, 21);
		contentPane.add(输入name);
		
		JLabel lblNewLabel_2 = new JLabel("商品数量");
		lblNewLabel_2.setBounds(10, 100, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextPane 输入sl = new JTextPane();
		输入sl.setBounds(67, 94, 117, 21);
		contentPane.add(输入sl);
		
		JLabel lblNewLabel_3 = new JLabel("单价");
		lblNewLabel_3.setBounds(10, 136, 50, 15);
		contentPane.add(lblNewLabel_3);
		
		JTextPane 输入money = new JTextPane();
		输入money.setBounds(67, 130, 117, 21);
		contentPane.add(输入money);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zl=输入zl.getText();
				String name=输入name.getText();
				String sl=输入sl.getText();//Integer.parseInt()
				String money=输入money.getText();//Float.parseFloat()
				pdadd a=new pdadd();
				a.pdadd(zl, name, sl, money);
				dispose();
				管理jm r=new 管理jm();
				r.show();
			}
		});
		btnNewButton.setBounds(36, 172, 97, 23);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/336.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}
