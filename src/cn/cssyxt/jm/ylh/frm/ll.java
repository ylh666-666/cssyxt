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
	 * ������
	 */
	public ll() {
		setTitle("\u6B22\u8FCE\u2501(*\uFF40\u2200\u00B4*)\u30CE\u4EBB!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5DE5\u5177");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton_2 = new JButton("ͳ��������Ϣ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ͳ��jm s=new ͳ��jm();
				s.show();
			}
		});
		mnNewMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��Ʒ�������");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				����jm t=new ����jm();
				t.show();
			}
		});
		mnNewMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ʱ����������");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ʱ���jm u=new ʱ���jm();
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
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/556.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 79, 406, 54);
		desktopPane.add(toolBar);
		
		JButton btnNewButton = new JButton("���˽���");
		btnNewButton.setIcon(new ImageIcon(ll.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				����jm a=new ����jm();
				a.show();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�������");
		btnNewButton_1.setIcon(new ImageIcon(ll.class.getResource("/\u56FE\u7247/d6.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				����jm a=new ����jm();
				a.show();
			}
		});
		toolBar.add(btnNewButton_1);
	}
}
