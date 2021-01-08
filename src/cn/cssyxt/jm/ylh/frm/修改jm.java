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

public class 修改jm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					修改jm frame = new 修改jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 修改界面，对商品进行修改
	 */
	public 修改jm() {
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
		
		JLabel lblNewLabel_1 = new JLabel("种类");
		lblNewLabel_1.setBounds(10, 41, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane xgzl = new JTextPane();
		xgzl.setBounds(58, 35, 157, 21);
		contentPane.add(xgzl);
		
		JLabel lblNewLabel_2 = new JLabel("商品名");
		lblNewLabel_2.setBounds(10, 77, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextPane xgspm = new JTextPane();
		xgspm.setBounds(58, 71, 157, 21);
		contentPane.add(xgspm);
		
		JLabel lblNewLabel_3 = new JLabel("数量");
		lblNewLabel_3.setBounds(10, 119, 44, 15);
		contentPane.add(lblNewLabel_3);
		
		JTextPane xgsl = new JTextPane();
		xgsl.setBounds(58, 113, 157, 21);
		contentPane.add(xgsl);
		
		JLabel lblNewLabel_4 = new JLabel("价格");
		lblNewLabel_4.setBounds(10, 158, 44, 15);
		contentPane.add(lblNewLabel_4);
		
		JTextPane xgjg = new JTextPane();
		xgjg.setBounds(58, 152, 157, 21);
		contentPane.add(xgjg);
		
		
		JButton btnNewButton = new JButton("提交修改");
		btnNewButton.setIcon(new ImageIcon(修改jm.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "确定要提交修改后的数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
					//JOptionPane.showMessageDialog(null, "修改成功", "修改成功", JOptionPane.NO_OPTION);
				    
					lj t=new lj();
					String a1="update 商品add set zl=?,sl=?,money=? where name=?";//使用占位符便于sql识别Integer.parseInt(sl), Float.parseFloat(money));
					try{
					Connection conn=t.getConnection();//获取数据库接
					PreparedStatement s = conn.prepareStatement(a1);
					//int changed=s.executeUpdate();
					s.setString(1, xgzl.getText());
					int oo=Integer.parseInt(xgsl.getText());
					s.setInt(2, oo);
					float uu=Float.parseFloat(xgjg.getText());
						s.setFloat(3,uu);
						s.setString(4,xgspm.getText());
						s.executeUpdate();
						
				        if(s.executeUpdate()==0) {JOptionPane.showMessageDialog(null, "无该商品，请重新输入");}
				        else { JOptionPane.showMessageDialog(null, "修改成功", "修改成功", JOptionPane.NO_OPTION);}
				        s.close();	
				        conn.close();
				        
				       
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "无该商品，请重新输入");
					}
					
					
				  } else {
				    JOptionPane.showMessageDialog(null, "请重新操作数据");
				  }
			}
		});
		btnNewButton.setBounds(81, 200, 115, 23);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/apic29974.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}
