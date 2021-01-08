package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.cssyxt.sjk.ylh.dbc.sjk;
import cn.cssyxt.stljm.ylh.vo.cssyxt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class denglu extends JFrame {

	private JPanel contentPane;
	private JPasswordField mm输入;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					denglu frame = new denglu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 登录界面
	 */
	public denglu() {
		setTitle("\u8D85\u5E02\u6536\u94F6\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT->DISPOSE可不同时关闭
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setBounds(10, 41, 41, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane zh输入 = new JTextPane();
		zh输入.setBounds(61, 35, 137, 21);
		contentPane.add(zh输入);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(10, 89, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		mm输入 = new JPasswordField();
		mm输入.setBounds(61, 86, 137, 21);
		contentPane.add(mm输入);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zh=zh输入.getText();
				String mm=new String(mm输入.getPassword());
				cssyxt u=new cssyxt();
				u.setZh(zh);
				u.setMm(mm);
				
				sjk r=new sjk();
				r.setcssyxt(u);
				if(r.JudgeAdmin()==0) {
                	//弹出账号或密码错误的窗口
                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
                	//清除密码框中的信息
                	mm输入.setText("");
                	//清除账号框中的信息
                	zh输入.setText("");
                	
                	//System.out.println("登陆失败");
                } else {
                	//弹出登录成功的窗口
                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
                	//点击确定后会跳转到主窗口
                	ll a=new ll();
    				a.show();
                    
                        
                }
				
			}
		});
		btnNewButton.setBounds(21, 137, 63, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				注册jm a=new 注册jm();
				a.show();
			}
		});
		btnNewButton_1.setBounds(90, 137, 63, 23);
		contentPane.add(btnNewButton_1);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/ppo.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}
