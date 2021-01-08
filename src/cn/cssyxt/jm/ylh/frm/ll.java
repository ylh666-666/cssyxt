package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ll extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ll frame = new ll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 主界面
	 */
	public ll() {
		setTitle("\u6B22\u8FCE\u2501(*\uFF40\u2200\u00B4*)\u30CE\u4EBB!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5DE5\u5177");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton_2 = new JButton("统计销售信息");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				统计jm s=new 统计jm();
				s.show();
			}
		});
		mnNewMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("商品分类管理");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				分类jm t=new 分类jm();
				t.show();
			}
		});
		mnNewMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("时间段销售情况");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				时间段jm u=new 时间段jm();
				u.show();
			}
		});
		mnNewMenu.add(btnNewButton_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/556.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 79, 406, 54);
		desktopPane.add(toolBar);
		
		JButton btnNewButton = new JButton("收账界面");
		btnNewButton.setIcon(new ImageIcon(ll.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				收账jm a=new 收账jm();
				a.show();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("管理界面");
		btnNewButton_1.setIcon(new ImageIcon(ll.class.getResource("/\u56FE\u7247/d6.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				管理jm a=new 管理jm();
				a.show();
			}
		});
		toolBar.add(btnNewButton_1);
	}
}
